package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import Modelo.AccidenteVehicular;
import Modelo.Incendio;
import Modelo.Robo;
import Modelo.Emergencia;
import Modelo.Interfaces.IServicioDeEmergencia;
import Modelo.Observer.ObserverEmergencias;
import Modelo.Observer.SujetoEmergencias;
import Modelo.Servicios.Ambulancia;
import Modelo.Servicios.Bomberos;
import Modelo.Servicios.Policia;
import Modelo.Strategy.StrategyPrioridad;
import Modelo.Strategy.StrategyPrioridadGravedad;

public class SistemaEmergencias implements SujetoEmergencias {
    //este va a ser el singleton
    private static SistemaEmergencias instancia;
    private List<Emergencia> ListaEmergencias; 
    private List<IServicioDeEmergencia> ListaRecursos;
    private List<ObserverEmergencias> Observadores;
    private StrategyPrioridad strategyPrioridad;
    private int emergenciasAtendidas;
    private long tiempoTotalAtencion;
    private SistemaEmergencias(){
        strategyPrioridad = new StrategyPrioridadGravedad(); 
        ListaEmergencias=new ArrayList<>();
        ListaRecursos=new ArrayList<>();
        Observadores=new ArrayList<>();   
        emergenciasAtendidas = 0;
        tiempoTotalAtencion = 0;

    }
    public static SistemaEmergencias getInstancia(){
        if(instancia==null){
            instancia=new SistemaEmergencias();
        }
        return instancia;
    }
    @Override
    public void agregarObservador(ObserverEmergencias observerEmergencias) {
       Observadores.add(observerEmergencias);    
    }

    @Override
    public void eliminarObservador(ObserverEmergencias observerEmergencias) {
     Observadores.remove(observerEmergencias);  
    }

    @Override
    public void notificarEmergencias(Emergencia emergencia) {
        for(ObserverEmergencias observador: Observadores){
            observador.onNuevaEmergencia(emergencia);
        }
    }
    //vamos a centralizar la logica del sistema de emergencias
    public void registrarRecurso(IServicioDeEmergencia recurso) {
        ListaRecursos.add(recurso);
        //agregamos el recurso a la lista de recursos   
    }
    public void mostrarEstadoRecursos() {
        System.out.println("\n=== EL ESTADO ACTUAL DE RECURSOS ===");
        for (IServicioDeEmergencia r : ListaRecursos) {
            System.out.println(r.toString());
        }
    }
// Ejemplo de uso de Lambda para filtrar recursos disponibles
    public List<IServicioDeEmergencia> filtrarRecursosDisponibles() {
        return ListaRecursos.stream()
                .filter(r -> r.estaDisponible())
                .collect(Collectors.toList());
    }
    public void registrarNuevaEmergencia(Emergencia e) {
        ListaEmergencias.add(e);
        notificarEmergencias(e);
    }
    public List<Emergencia> getEmergenciasPendientes() {
        return ListaEmergencias.stream()
        // Filtrar emergencias pendientes
                .filter(e -> !e.isAtendida())
                // Ordenar emergencias por prioridad  
                //ESTO LO PUSE YO  
                .sorted((e1, e2) -> strategyPrioridad.calcularPrioridad(e1) - strategyPrioridad.calcularPrioridad(e2))
                .collect(Collectors.toList());
    }
    public void asignarRecursosAEmergencia(Emergencia emergencia) {
        // Buscamos recursos disponibles
        List<IServicioDeEmergencia> disponibles = filtrarRecursosDisponibles();
        if (disponibles.isEmpty()) {
            System.out.println("No hay recursos disponibles para esta emergencia.");
            return;
        }
        System.out.println("-> Estamos asignando recursos automáticamente...");

        if (emergencia instanceof Incendio) {
            // Buscamos recursos disponibles
            for (IServicioDeEmergencia r : disponibles) {
                if (r instanceof Bomberos) {
                    r.atenderEmergencia(emergencia);
                    break;
                }
            }
        } else if (emergencia instanceof AccidenteVehicular) {
            // Buscamos recursos disponibles
            for (IServicioDeEmergencia r : disponibles) {
                if (r instanceof Ambulancia) {
                    r.atenderEmergencia(emergencia);
                    break;
                }
            }
        } else if (emergencia instanceof Robo) {
            // Buscamos recursos disponibles
            for (IServicioDeEmergencia r : disponibles) {
                if (r instanceof Policia) {
                    r.atenderEmergencia(emergencia);
                    break;
                }
            }
        }
    }
    public void atenderEmergencia(Emergencia e) {
        if (e.isAtendida()) {
            System.out.println("Esta emergencia ya fue atendida.");
            return;
        }
        //ESTE LO PUSE YO
        System.out.println("-> Atendiendo emergencia: " + e.getDescripcion());
        e.IniciarAtencion();
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        e.FinalizarAtencion();
        System.out.println("Emergencia atendida: " + e.getDescripcion());

        emergenciasAtendidas++;
        tiempoTotalAtencion += e.getTiempoRespuesta();
}
public void mostrarEstadisticas() {
    System.out.println("\n=== ESTAS SON LAS ESTADÍSTICAS DEL DÍA ===");
    System.out.println("Emergencias atendidas: " + emergenciasAtendidas);
 // segun la cantidad de emergencias atendidas se calcula el promedio
    long promedioMs = 0;
    if (emergenciasAtendidas > 0) {
        promedioMs = tiempoTotalAtencion / emergenciasAtendidas;
    }
    double promedioSeg = promedioMs / 1000.0;
    System.out.println("Tiempo promedio de respuesta: " + promedioSeg + " seg.");
// segun la cantidad de emergencias atendidas se calcula la cantidad de emergencias no atendidas
    long noAtendidas = ListaEmergencias.stream()
            .filter(e -> !e.isAtendida())
            .count();
    System.out.println("Emergencias no atendidas: " + noAtendidas);
}
}
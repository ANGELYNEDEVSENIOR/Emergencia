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
        for (IServicioEmergencia r : ListaRecursos) {
            System.out.println(r.toString());
        }
    }
// Ejemplo de uso de Lambda para filtrar recursos disponibles
    public List<IServicioEmergencia> filtrarRecursosDisponibles() {
        return listaRecursos.stream()
                .filter(r -> r.estaDisponible())
                .collect(Collectors.toList());
    }
    public void registrarNuevaEmergencia(Emergencia e) {
        listaEmergencias.add(e);
        notificarEmergencias(e);
    }
    public List<Emergencia> getEmergenciasPendientes() {
        return listaEmergencias.stream()
                .filter(e -> !e.isAtendida())
                .collect(Collectors.toList());
    }
    public void registrarNuevaEmergencia(Emergencia e) {
        listaEmergencias.add(e);
        notificarEmergencias(e);
    }
 //vamos a centralizar la logica del sistema de emergencias
}

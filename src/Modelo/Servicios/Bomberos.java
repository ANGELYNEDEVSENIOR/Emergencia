package Modelo.Servicios;
import Modelo.Emergencia;

public class Bomberos extends ServicioBase{
    public Bomberos(String id, int personalDisponibles, int combustible) {
        super(id, personalDisponibles, combustible);
        //se crea un constructor de la clase padre
    }

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
       System.out.println("Los bomberos estan en camino para atender la emergencia!!!");
       System.out.println("-> [Bomberos" + getId() + "]: "+emergencia.getDescripcion());
       //se muestra la emergencia
       //getDescripcion nos devueñve la informacion de la emergencia
       asignarPersonal(5);
       gastarCombustible(10);
    }

}

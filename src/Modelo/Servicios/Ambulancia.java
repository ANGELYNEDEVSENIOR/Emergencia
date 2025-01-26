import Modelo.Emergencia;

public class Ambulancia  extends ServicioBase {
    public Ambulancia (String id, int personalDisponibles, int combustible) {
        super(id, personalDisponibles, combustible);
        //se crea un constructor de la clase padre
    }

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
       System.out.println("Los paramedicos estan en camino para atender la emergencia!!!");
       System.out.println("-> [Paramedicos" + getId() + "]: "+emergencia.getDescripcion());
       //se muestra la emergencia
       //getDescripcion nos devueñve la informacion de la emergencia
       asignarPersonal(3);
       gastarCombustible(5);
    }
}

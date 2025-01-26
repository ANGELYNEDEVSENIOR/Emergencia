public class Policia  extends ServicioBase{
    public Policia(String id, int personalDisponibles, int combustible) {
        super(id, personalDisponibles, combustible);
        //se crea un constructor de la clase padre
    }

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
       System.out.println("Los Policias estan en camino para atender la emergencia!!!");
       System.out.println("-> [Policias" + getId() + "]: "+emergencia.getDescripcion());
       //se muestra la emergencia
       //getDescripcion nos devueñve la informacion de la emergencia
       asignarPersonal(2);
       gastarCombustible(3);
    }
}

public class Bomberos extends ServicioBase{
    public Bomberos(String id, int personalDisponibles, int combustible) {
        super(id, personalDisponibles, combustible);
        //se crea un constructor de la clase padre
    }

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atenderEmergencia'");
    }

}

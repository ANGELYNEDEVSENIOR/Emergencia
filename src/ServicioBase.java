public class ServicioBase implements IServicioDeEmergencia {
    //idicar atributos propios de las bases
    private String id;
    private int personalDisponibles;
    private int combustible;
    // hacer constructor de servicio base
    public ServicioBase(String id, int personalDisponibles, int combustible) {
        this.id = id;
        this.personalDisponibles = personalDisponibles; 
        this.combustible = combustible;        
    }

    @Override
    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public int getPersonalDisponibles() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonalDisponibles'");
    }

    @Override
    public int getCombstible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCombstible'");
    }

    @Override
    public boolean estaDisponible() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'estaDisponible'");
    }

    @Override
    public void asignarPersonal(int personal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarPersonal'");
    }

    @Override
    public void liberarPersonal(int personal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'liberarPersonal'");
    }

    @Override
    public void asignarCombustible(int combustible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignarCombustible'");
    }

    @Override
    public void liberarCombustible(int combustible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'liberarCombustible'");
    }

    @Override
    public void atenderEmergencia(Emergencia emergencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atenderEmergencia'");
    }

}

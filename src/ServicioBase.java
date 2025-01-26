public abstract class ServicioBase implements IServicioDeEmergencia {
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
        return id;
    }

    @Override
    public int getPersonalDisponibles() {
      return personalDisponibles;
    }

    @Override
    public int getCombstible() {
      return combustible;
    }

    @Override
    public boolean estaDisponible() {
        return personalDisponibles > 0 && combustible > 0;
        // si hay personal disponible y combustible disponible
    }

    @Override
    //asignar personal
    public void asignarPersonal(int cantidad) {
        if(cantidad <= personalDisponibles){
            personalDisponibles -= cantidad;
        }else{
            System.out.println("No hay suficiente personal disponible"+ id);
        }
    }

    @Override
    public void liberarPersonal(int cantidad) {
        personalDisponibles += cantidad;
    }

    @Override
    public void gastarCombustible(int cantidad) {
        combustible =Math.max(0, combustible - cantidad);
        //si la cantidad de combustible es mayor a 0 entonces lo restamos de lo contrario lo ponemos en 0
    }

    @Override
    public void tanquearCombustible(int cantidad) {
        combustible += cantidad;
    }

    //metodo para atender la emergencia abstracto
    public abstract void atenderEmergencia(Emergencia emergencia);

    @Override
    public String toString() {
        return "ServicioBase [id=" + id + ", personalDisponibles=" + personalDisponibles + ", combustible="
                + combustible + "]";
    }

}

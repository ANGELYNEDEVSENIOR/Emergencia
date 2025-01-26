public interface IServicioDeEmergencia {
    //metodos
String getId(); 

int getPersonalDisponibles();

int getCombstible();

boolean estaDisponible();

void asignarPersonal(int personal);

void liberarPersonal(int personal);

void asignarCombustible(int combustible);

void liberarCombustible(int combustible);

void atenderEmergencia(Emergencia emergencia);

}

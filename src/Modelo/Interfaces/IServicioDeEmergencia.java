package Modelo.Interfaces;

import Modelo.Emergencia;

public interface IServicioDeEmergencia {
    //metodos
String getId(); 

int getPersonalDisponibles();

int getCombstible();

boolean estaDisponible();

void asignarPersonal(int cantidad);

void liberarPersonal(int cantidad);

void gastarCombustible(int cantidad);

void tanquearCombustible(int cantidad);

void atenderEmergencia(Emergencia emergencia);

}

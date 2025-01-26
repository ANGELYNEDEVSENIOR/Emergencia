package Modelo.Observer;

import Modelo.Emergencia;

public interface SujetoEmergencias {
//agregamos metodos
void agregarObservador(ObserverEmergencias observador);

void eliminarObservador(ObserverEmergencias observador);

void notificarEmergencias(Emergencia emergencia);

}

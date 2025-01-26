package controller;

import Modelo.Emergencia;
import Modelo.Observer.ObserverEmergencias;
import Modelo.Observer.SujetoEmergencias;

public class SistemaEmergencias implements SujetoEmergencias {
    //este va a ser el singleton

    @Override
    public void agregarObservador(ObserverEmergencias observador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarObservador'");
    }

    @Override
    public void eliminarObservador(ObserverEmergencias observador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarObservador'");
    }

    @Override
    public void notificarEmergencias(Emergencia emergencia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notificarEmergencias'");
    }
    //vamos a centralizar la logica del sistema de emergencias

}

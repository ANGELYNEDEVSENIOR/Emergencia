package Modelo;

import untils.NivelGravedad;

public class Robo extends Emergencia{
    public Robo(String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
        super("Robo", ubicacion, nivelGravedad, tiempoRespuesta); 
    }
}

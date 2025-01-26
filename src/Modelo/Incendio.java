package Modelo;

import untils.NivelGravedad;

public class Incendio extends Emergencia{
 public Incendio(String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
    // ya existe el constructor de la clase padre que es Emergencia
    //incendio es un tipo de emergencia
     super("Incendio", ubicacion, nivelGravedad, tiempoRespuesta); 
 }
}

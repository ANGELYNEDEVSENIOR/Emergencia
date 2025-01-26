package Modelo;
public class Incendio extends Emergencia{
 public Incendio(String id, String ubicacion, int nivelGravedad, int tiempoRespuesta) {
    // ya existe el constructor de la clase padre que es Emergencia
    //incendio es un tipo de emergencia
     super("Incendio", ubicacion, nivelGravedad, tiempoRespuesta); 
 }
}

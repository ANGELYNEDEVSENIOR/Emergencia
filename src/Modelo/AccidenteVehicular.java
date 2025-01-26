package Modelo;
public class AccidenteVehicular extends Emergencia{
    public AccidenteVehicular( String ubicacion, int nivelGravedad, int tiempoRespuesta) {
        super("Accidente Vehicular", ubicacion, nivelGravedad, tiempoRespuesta); 
    }

}

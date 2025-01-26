package Modelo.Factory;

import Modelo.AccidenteVehicular;
import Modelo.Emergencia;
import Modelo.Incendio;
import Modelo.Robo;
import untils.NivelGravedad;
import untils.TipoEmergencia;

public class FactoryEmergencias {
//creamos un constructor que reciba toda la informacion de la emergencia
public static Emergencia CrearEmergencia(TipoEmergencia tipo, String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
    switch (tipo) {
        case ROBO:
            return new Robo(ubicacion, nivelGravedad, tiempoRespuesta);
        case ACCIDENTE_VEHICULAR:       
            return new AccidenteVehicular(ubicacion, nivelGravedad, tiempoRespuesta);
        case INCENDIO:
            return new Incendio(ubicacion, nivelGravedad, tiempoRespuesta);
        default:
            return null;
    }
}
}

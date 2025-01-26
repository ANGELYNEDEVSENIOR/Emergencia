package Modelo.Strategy;

import Modelo.Emergencia;

public class StrategyPrioridadCercania implements StrategyPrioridad {
//creacion de clase interna mapa urbano
private class MapaUrbano {
        public int calcularDistancia(String ubicacion) {
            switch (ubicacion.toLowerCase()) {
                case "ZONA NORTE":
                return 8;    
                case "ZONA SUR":
                return 10; 
                case "ZONA CENTRO":
                return 2; 
                case "ZONA ORIENTE":
                return 5;
                case "ZONA OCCIDENTE":
                return 6;  
                default:
                    return 10;
  //estimacion de la distancia
            }
        }
}
public MapaUrbano mapaUrbano = new MapaUrbano();
@Override
public int calcularPrioridad(Emergencia emergencia) {
  int calcularDistancia = mapaUrbano.calcularDistancia(emergencia.getUbicacion());
  return 10 - calcularDistancia;
}
}

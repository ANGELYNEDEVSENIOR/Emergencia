package Modelo.Strategy;

import Modelo.Emergencia;


public class StrategyPrioridadGravedad implements StrategyPrioridad {

    @Override
    public int calcularPrioridad(Emergencia emergencia) {
      switch (emergencia.getNivelGravedad()) {
        //segun el nivel de gravedad se le asigna una prioridad
        case ALTO:
            return 3;
        case MEDIO:
            return 2;
        case BAJO:
            return 1;
        default:
         return 1;
      }
    }

}

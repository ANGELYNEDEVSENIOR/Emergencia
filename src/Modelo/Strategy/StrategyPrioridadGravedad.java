package Modelo.Strategy;

import Modelo.Emergencia;

public class StrategyPrioridadGravedad implements StrategyPrioridad {

    @Override
    public int calcularPrioridad(Emergencia emergencia) {
      return emergencia.getNivelGravedad();
      //lo usamos para calcular la prioridad de la emergencia
    }

}

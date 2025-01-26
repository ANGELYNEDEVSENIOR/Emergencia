package Modelo.Strategy;

import Modelo.Emergencia;

public interface StrategyPrioridad {
    //metodo para calcular la prioridad de la emergencia
int calcularPrioridad(Emergencia emergencia);   
}

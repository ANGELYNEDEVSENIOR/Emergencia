package Modelo;

import untils.NivelGravedad;

public abstract class Emergencia {
    //encapcsulamos los atributos
private String tipo;
private String ubicacion;
private NivelGravedad nivelGravedad;//3 alto, 2 medio, 1 bajo
private int tiempoRespuesta;// en minutos
private boolean atendida;
private long tiempoInicioAtencion;
private long tiempoFinAtencion;
//definimos 
public Emergencia(String tipo, String ubicacion, NivelGravedad nivelGravedad, int tiempoRespuesta) {
    this.tipo = tipo;
    this.ubicacion = ubicacion;
    this.nivelGravedad = nivelGravedad;
    this.tiempoRespuesta = tiempoRespuesta;
    this.atendida = false;   
}
public String getTipo() {
    return tipo;
}
public void setTipo(String tipo) {
    this.tipo = tipo;
}
public String getUbicacion() {
    return ubicacion;
}
public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
}
public NivelGravedad getNivelGravedad() {
    return nivelGravedad;
}
public void setNivelGravedad(NivelGravedad nivelGravedad) {
    this.nivelGravedad = nivelGravedad;
}
public int getTiempoRespuesta() {
    return tiempoRespuesta;
}
public void setTiempoRespuesta(int tiempoRespuesta) {
    this.tiempoRespuesta = tiempoRespuesta;
}
public boolean isAtendida() {
    return atendida;
}
public void setAtendida(boolean atendida) {
    this.atendida = atendida;
}
public long getTiempoInicioAtencion() {
    return tiempoInicioAtencion;
}
public void setTiempoInicioAtencion(long tiempoInicioAtencion) {
    this.tiempoInicioAtencion = tiempoInicioAtencion;
}
public long getTiempoFinAtencion() {
    return tiempoFinAtencion;
}
public void setTiempoFinAtencion(long tiempoFinAtencion) {
    this.tiempoFinAtencion = tiempoFinAtencion;
}
//metodo para atender la emergencia
public void IniciarAtencion() {
    this.tiempoInicioAtencion = System.currentTimeMillis();  
}
//metodo para finalizar la atencion
public void FinalizarAtencion() {
    this.atendida = true;
    this.tiempoFinAtencion = System.currentTimeMillis();
}
//metodo para calcular el tiempo de atencion
public long calcularTiempoAtencion() {
    return this.tiempoFinAtencion - this.tiempoInicioAtencion;
}
//metodo para mostrar la emergencia
public String getDescripcion() {
    return String.format("%s en %s (gravedad: %s)", tipo, ubicacion, nivelGravedad);
}
//metodo para mostrar la emergencia
public String toString () {
    return getDescripcion()+ "Tiempo estimado: " +tiempoRespuesta + "minutos";
}
}
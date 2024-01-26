/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial6Objetos;

/**
 *
 * @author Piggypink
 */
public abstract class ServicioMetereologico {
    private String nombre;
    private String latitud;
    private String longitud;
    private double[][] temperaturas;

    public ServicioMetereologico(String nombre, String latitud, String longitud, int n) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.temperaturas = new double[3][n];
    }
    
    public abstract String calcularPromedio();

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    
    public double[][] getTemperaturas() {
        return temperaturas;
    }

    public void setTemperaturas(double[][] temperaturas) {
        this.temperaturas = temperaturas;
    }
    
    public void almacenarTemperatura(int mes,int anio, double temp){
        this.temperaturas[mes][anio] = temp;
    }
    
    public double getTemperatura(int mes, int anio){
        return this.temperaturas[mes][anio];
    }
    
    
}

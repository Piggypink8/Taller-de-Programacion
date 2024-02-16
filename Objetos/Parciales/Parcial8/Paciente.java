/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial8Objetos;

/**
 *
 * @author Sandra
 */
public class Paciente {
    private String nombre;
    private boolean obraSocial;
    private double costoAbonar;

    @Override
    public String toString() {
        return "Paciente{" + "nombre=" + nombre + ", obraSocial=" + obraSocial + ", costoAbonar=" + costoAbonar + '}';
    }

    public Paciente(String nombre, boolean obraSocial, double costoAbonar) {
        this.nombre = nombre;
        this.obraSocial = obraSocial;
        this.costoAbonar = costoAbonar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(boolean obraSocial) {
        this.obraSocial = obraSocial;
    }

    public double getCostoAbonar() {
        return costoAbonar;
    }

    public void setCostoAbonar(double costoAbonar) {
        this.costoAbonar = costoAbonar;
    }
    
}

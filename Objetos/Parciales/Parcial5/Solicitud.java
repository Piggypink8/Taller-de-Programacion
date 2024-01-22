/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial5Objetos;

/**
 *
 * @author Piggypink
 */
public class Solicitud {
    private String investigador;
    private String nombreTrabajo;
    private String destino;
    private double costoPasajeIda;
    private double costoPasajeVuelta;
    private double tasaEmbarque;
    private int dias;
    private double montoHotel;
    private boolean subsidio;

    public Solicitud(String investigador, String nombreTrabajo, String destino, double costoPasajeIda, double costoPasajeVuelta, double tasaEmbarque, int dias, double montoHotel) {
        this.investigador = investigador;
        this.nombreTrabajo = nombreTrabajo;
        this.destino = destino;
        this.costoPasajeIda = costoPasajeIda;
        this.costoPasajeVuelta = costoPasajeVuelta;
        this.tasaEmbarque = tasaEmbarque;
        this.dias = dias;
        this.montoHotel = montoHotel;
        this.subsidio = false;
    }

    public String getInvestigador() {
        return investigador;
    }

    public void setInvestigador(String investigador) {
        this.investigador = investigador;
    }

    public String getNombreTrabajo() {
        return nombreTrabajo;
    }

    public void setNombreTrabajo(String nombreTrabajo) {
        this.nombreTrabajo = nombreTrabajo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getCostoPasajeIda() {
        return costoPasajeIda;
    }

    public void setCostoPasajeIda(double costoPasajeIda) {
        this.costoPasajeIda = costoPasajeIda;
    }

    public double getCostoPasajeVuelta() {
        return costoPasajeVuelta;
    }

    public void setCostoPasajeVuelta(double costoPasajeVuelta) {
        this.costoPasajeVuelta = costoPasajeVuelta;
    }

    public double getTasaEmbarque() {
        return (this.getCostoPasajeIda() + this.getCostoPasajeVuelta()) * this.tasaEmbarque;
    }

    public void setTasaEmbarque(double tasaEmbarque) {
        this.tasaEmbarque = tasaEmbarque;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getMontoHotel() {
        return montoHotel;
    }

    public void setMontoHotel(double montoHotel) {
        this.montoHotel = montoHotel;
    }

    public boolean isSubsidio() {
        return subsidio;
    }

    public void setSubsidio(boolean subsidio) {
        this.subsidio = subsidio;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "investigador=" + investigador + ", nombreTrabajo=" + nombreTrabajo + ", destino=" + destino + ", costoPasajeIda=" + costoPasajeIda + ", costoPasajeVuelta=" + costoPasajeVuelta + ", tasaEmbarque=" + tasaEmbarque + ", dias=" + dias + ", montoHotel=" + montoHotel + ", subsidio=" + subsidio + '}';
    }
    
    
    

    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial1Objetos;

/**
 *
 * @author Piggypink
 */
public class Venta {
    public String dni;
    public int cantLitros;
    public double monto;
    public String metodoPago;

    public Venta(String dni, int cantLitros, double monto, String metodoPago) {
        this.dni = dni;
        this.cantLitros = cantLitros;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCantLitros() {
        return cantLitros;
    }

    public void setCantLitros(int cantLitros) {
        this.cantLitros = cantLitros;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "Venta{" + "dni=" + dni + ", cantLitros=" + cantLitros + ", monto=" + monto + ", metodoPago=" + metodoPago + '}';
    }
    
    
}

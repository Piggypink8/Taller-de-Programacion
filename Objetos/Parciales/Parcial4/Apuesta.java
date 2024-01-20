/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial4Objetos;

/**
 *
 * @author Piggypink
 */
public class Apuesta {
    private String nombre;
    private String dni;
    private int id;
    private String resultado;
    private double monto;

    public Apuesta(String nombre, String dni, int id, String resultado, double monto) {
        this.nombre = nombre;
        this.dni = dni;
        this.id = id;
        this.resultado = resultado;
        this.monto = monto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    public double getFactorDePago(String resultado){
        if(resultado.equals("victoria local"))
            return 0.3;
        else if (resultado.equals("victoria visitante"))
            return 0.4;
        else
            return 0.7;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial3Objetos;

/**
 *
 * @author Piggypink
 */
public class Cuenta {
    private String CBU;
    private String alias;
    private String DNI;
    private String moneda;
    private double monto;

    public Cuenta(String CBU,String alias, String DNI, String moneda) {
        this.CBU = CBU;
        this.alias = alias;
        this.DNI = DNI;
        this.moneda = moneda;
        this.monto = 0;
    }

    public String getCBU() {
        return CBU;
    }

    public void setCBU(String CBU) {
        this.CBU = CBU;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto += monto;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial3Objetos;

/**
 *
 * @author Piggypink
 */
public abstract class Banco {
    private String nombre;
    private int empleados;
    private Cuenta[] cuentas;
    private int dimL = 0;

    public Banco(String nombre, int empleados, int n) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.cuentas = new Cuenta[n];
    }
    
    public abstract boolean agregarCuenta(Cuenta cuenta);
  
    public Cuenta obtenerCBU(String CBU){
        boolean ok = false;
        int i = 1;
        Cuenta cuenta = null;
        while(i <= this.dimL && !ok){
            if(this.cuentas[i].getCBU().equals(CBU)){
                ok = true;
                cuenta = this.cuentas[i];
            }
            i++;
        }
        return cuenta;
    }
    
    public void depositarDinero(String CBU, double monto){
        Cuenta cuenta = this.obtenerCBU(CBU);
        if(cuenta != null){
            cuenta.setMonto(monto);
        }
    }
    
    public abstract boolean puedeRecibirTarjeta(String CBU);
    

    public int getDimL() {
        return dimL;
    }

    public void setDimL() {
        this.dimL++;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEmpleados() {
        return empleados;
    }

    public void setEmpleados(int empleados) {
        this.empleados = empleados;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }

    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }
    
    
    
}

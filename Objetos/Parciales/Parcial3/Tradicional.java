/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial3Objetos;

/**
 *
 * @author Piggypink
 */
public class Tradicional extends Banco{
    private String direccion;
    private String localidad;
    private int cantCuentasUSD;

    public Tradicional(String nombre, int empleados, int n, String direccion, String localidad, int cantCuentasUSD){
        super(nombre, empleados, n);
        this.direccion = direccion;
        this.cantCuentasUSD = cantCuentasUSD;
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantCuentasUSD() {
        return cantCuentasUSD;
    }

    public void setCantCuentasUSD(int cantCuentasUSD) {
        this.cantCuentasUSD = cantCuentasUSD;
    }

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        if(cuenta.getMoneda().equals("USD")){
            if(this.cantCuentasUSD < 100){
                this.cantCuentasUSD++;
                this.getCuentas()[this.getDimL()] = cuenta;
                this.setDimL();               
                return true;
            }
        } else {
            this.getCuentas()[this.getDimL()] = cuenta;
            this.setDimL();
            return true;
        }
        return false;
    }

    @Override
    public boolean puedeRecibirTarjeta(String CBU) {
        Cuenta cuenta = this.obtenerCBU(CBU);
        
        if(cuenta.getMoneda().equals("USD")){
            return cuenta.getMonto() > 500;
        } else if(cuenta.getMoneda().equals("Pesos")){
             return cuenta.getMonto() > 70000;
        }
        
        return false;
    }
    
}

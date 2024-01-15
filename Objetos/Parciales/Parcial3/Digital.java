/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial3Objetos;

/**
 *
 * @author Piggypink
 */
public class Digital extends Banco{
    private String direccionWeb;

    public Digital(String nombre, int empleados, int n, String direccionWeb) {
        super(nombre, empleados, n);
        this.direccionWeb = direccionWeb;
    }

    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    @Override
    public boolean agregarCuenta(Cuenta cuenta) {
        this.getCuentas()[this.getDimL()] = cuenta;
        this.setDimL();
        return true;
    }

    @Override
    public boolean puedeRecibirTarjeta(String CBU) {
         Cuenta cuenta = this.obtenerCBU(CBU);
         
         if(cuenta.getMoneda().equals("Pesos")){
             return cuenta.getMonto() > 100000;
         }
         
         return false;
    }
    
    
    
}

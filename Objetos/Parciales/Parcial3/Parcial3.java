/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parcial3Objetos;

/**
 *
 * @author Piggypink
 */
public class Parcial3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Banco tradicional = new Tradicional("Galicia", 5,3,"Av pueyrredon","CABA",10);
        Banco digital = new Digital("Uala", 5,3,"www.uala.com");
        
        Cuenta cuenta0 = new Cuenta("000","Monte.ola","37684986","USD");
        Cuenta cuenta1 = new Cuenta("111","Juan","41567001","USD");
        Cuenta cuenta2 = new Cuenta("222","Pedro","26456889","Pesos");
        Cuenta cuenta3 = new Cuenta("333","Sara","19234115","Pesos");
        Cuenta cuenta4 = new Cuenta("444","Mora","32998123","USD");
        
        tradicional.agregarCuenta(cuenta0);
        tradicional.agregarCuenta(cuenta1);
        tradicional.agregarCuenta(cuenta2);
        
        digital.agregarCuenta(cuenta3);
        digital.agregarCuenta(cuenta4);
       
       
        tradicional.depositarDinero("111", 600);
        System.out.println(cuenta1.getMonto());
        
        System.out.print(tradicional.puedeRecibirTarjeta("111"));
    }

}
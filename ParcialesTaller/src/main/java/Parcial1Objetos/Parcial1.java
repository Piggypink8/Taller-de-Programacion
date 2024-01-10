/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Parcial1Objetos;


/**
 *
 * @author Piggypink
 */
public class Parcial1 {

    public static void main(String[] args) {
        EstacionDeServicio estacion = new EstacionDeServicio("Av DardoRocha");
        Surtidor surt1 = new Surtidor("Diesel",10,4);
        Surtidor surt2 = new Surtidor("Nafta",20,3);
        Surtidor surt3 = new Surtidor("Gas",5,3);
        
        System.out.println(estacion.agregarSurtidor(surt1));
        System.out.println(estacion.agregarSurtidor(surt2));
        System.out.println(estacion.agregarSurtidor(surt3));
        
        surt1.generarVenta("25876532", 10, "Efectivo");
        surt1.generarVenta("25876532", 10, "Efectivo");
        surt1.generarVenta("25876532", 10, "Efectivo");
        surt2.generarVenta("25876532", 10, "Tarjeta");
        surt2.generarVenta("25876532", 10, "Transferencia");
        surt3.generarVenta("25876532", 90, "Efectivo");
        
        System.out.println(estacion.surtidorMayorMonto());
        
        System.out.println(estacion.toString());
    }
}

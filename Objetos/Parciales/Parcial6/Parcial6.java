/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parcial6Objetos;

/**
 *
 * @author Piggypink
 */
public class Parcial6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServicioMetereologico anios = new EstacionPromedioAnios("La Plata", "34,921 S", "57,955 O", 3);
        ServicioMetereologico meses = new EstacionPromedioMeses("Quilmes", "63,356 S", "125,431 O", 3);
        
        
        meses.almacenarTemperatura(0, 0, 30.0);
        meses.almacenarTemperatura(1, 0, 29.0);
        meses.almacenarTemperatura(2, 0, 24.0);
        
        meses.almacenarTemperatura(0, 1, 23.0);
        meses.almacenarTemperatura(1, 1, 28.0);
        meses.almacenarTemperatura(2, 1, 25.0);
        
        meses.almacenarTemperatura(0, 2, 30.0);
        meses.almacenarTemperatura(1, 2, 32.0);
        meses.almacenarTemperatura(2, 2, 27.0);
        
        
        anios.almacenarTemperatura(0, 0, 20.0);
        anios.almacenarTemperatura(1, 0, 23.0);
        anios.almacenarTemperatura(2, 0, 23.0);
        
        anios.almacenarTemperatura(0, 1, 23.0);
        anios.almacenarTemperatura(1, 1, 24.0);
        anios.almacenarTemperatura(2, 1, 26.0);
        
        anios.almacenarTemperatura(0, 2, 27.0);
        anios.almacenarTemperatura(1, 2, 20.0);
        anios.almacenarTemperatura(2, 2, 23.0);
        
        
        System.out.println(anios.calcularPromedio());
        
         
        System.out.println(meses.calcularPromedio());
    }
    
}

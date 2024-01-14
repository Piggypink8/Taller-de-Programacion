/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parcial2Objetos;

/**
 *
 * @author Piggypink
 */
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Torneo torneo = new Torneo("Mundial",3,4);
        Goleador goleador1 = new Goleador("Juan","Boca",3);
        Goleador goleador2 = new Goleador("Pedro","Boca",2);
        Goleador goleador3 = new Goleador("Marcos","River",5);
        Goleador goleador4 = new Goleador("Nacho","Velez",1);
        Goleador goleador5 = new Goleador("Joel","Belgrano",0);
        Goleador goleador6 = new Goleador("Emanuel","Belgrano",7);
        
        torneo.agregarGoleador(1, goleador5);
        torneo.agregarGoleador(1, goleador3);
        torneo.agregarGoleador(2, goleador2);
        torneo.agregarGoleador(2, goleador1); 
        torneo.agregarGoleador(2, goleador4);
        torneo.agregarGoleador(0, goleador6);
        
        System.out.print(torneo.obtenerGoleadorMenosGolesEn(1));
        
        System.out.print(torneo.toString());
        
        
 
        
        
    }
    
}

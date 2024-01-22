/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parcial5Objetos;

/**
 *
 * @author Piggypink
 */
public class Parcial5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Sistema avion = new VersionAvion(3);
        Sistema estadia = new VersionEstadia(3);
        
        Solicitud sol1 = new Solicitud("Juan","VH12","USA",1000,800,0.4,5,20);
        Solicitud sol2 = new Solicitud("Sara","AC12","China",2000,1800,0.9,10,40);
        Solicitud sol3 = new Solicitud("Hernan","AAA1","Spain",1300,1000,0.5,5,60);
        Solicitud sol4 = new Solicitud("Marcos","34RF","Germany",1200,1000,0.3,7,35);
        Solicitud sol5 = new Solicitud("Sofia","765G","USA",1000,800,0.4,3,20);

        avion.agregarSolicitud(sol1);
        avion.agregarSolicitud(sol2);
        avion.agregarSolicitud(sol3);
        
        estadia.agregarSolicitud(sol4);
        estadia.agregarSolicitud(sol5);
        
        avion.otorgarSubsidio(3000);
        System.out.println(avion.toString());
        
        estadia.otorgarSubsidio(200);
        System.out.println(estadia.toString());
    }
    
}

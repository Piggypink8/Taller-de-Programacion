/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2Objetos;

/**
 *
 * @author Piggypink
 */

public class Torneo {
    private String nombre;
    private Goleador[][] goleadores;
    private int[] dimLC;

    public Torneo(String nombre, int n, int m) {
        this.nombre = nombre;
        this.goleadores = new Goleador[n][m];
        this.dimLC = new int[m];
        for(int i = 0; i < this.dimLC.length; i++)
            this.dimLC[i] = 0;
    } 
    
    public void agregarGoleador(int x,Goleador goleador){       
        if(this.dimLC[x] < this.goleadores[x].length){  
            this.dimLC[x]++;
            this.goleadores[x][this.dimLC[x]] = goleador;
        }
    }
    
    public String obtenerGoleadorMenosGolesEn(int x){
        int min = 999;
        Goleador goleador = null;
        for(int i = 1; i <= this.dimLC[x]; i++){
            if(this.goleadores[x][i].getGoles() < min){
                min = this.goleadores[x][i].getGoles();
                goleador = this.goleadores[x][i];
            }
        }
        return goleador.toString();
    }
    
    public int cantGoleadores(){
        int sum = 0;
        for(int i =1; i <= this.dimLC.length; i++){
            if(this.dimLC != null)
                sum += this.dimLC[i];
        }
        return sum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Goleador[][] getGoleadores() {
        return goleadores;
    }

    public void setGoleadores(Goleador[][] goleadores) {
        this.goleadores = goleadores;
    }
    
     @Override
    public String toString() {
        String aux= "";
        String aux2= "";
        int j = 0;
        while(j < this.goleadores.length){
            if(this.goleadores[j] != null){
                aux += "\n" + "Fecha #" + (j+1) + " / Goleadores: ";
                for(int i = 1; i <= this.dimLC[j] ; i++){
                    aux2 += this.goleadores[j][i].toString()+  " ";
                }
                aux += aux2;
            }
            aux2 = "";
            j++;
        }
        return aux;
    }
    
}

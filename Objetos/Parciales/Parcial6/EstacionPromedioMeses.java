/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial6Objetos;

/**
 *
 * @author Piggypink
 */
public class EstacionPromedioMeses extends ServicioMetereologico {
  
    public EstacionPromedioMeses(String nombre, String latitud, String longitud, int n) {
        super(nombre, latitud, longitud, n);
    }

    @Override
    public String calcularPromedio() {
        double prom = 0;
        String aux = this.getNombre() + "(" + this.getLatitud() + " - "+ this.getLongitud() + "):" + "\n";
        for(int j=0; j < 3 ; j++){
            prom = 0;
            for(int i=0; i < this.getTemperaturas().length; i++){
                prom += this.getTemperatura(j, i);
            }
            prom = prom / 3;
            aux+= "Mes: " + j + ": " + prom + " °C" + "\n";
        }
        
        return aux;    }
  
    

}

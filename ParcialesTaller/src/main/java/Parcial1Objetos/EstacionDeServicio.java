/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial1Objetos;

/**
 *
 * @author Piggypink
 */
public class EstacionDeServicio {
    private String direccion;
    private Surtidor[] surtidores;
    private int dimL = 0;

    public EstacionDeServicio(String direccion) {
        this.direccion = direccion;
        this.surtidores = new Surtidor[6];
    }
    
    public boolean agregarSurtidor(Surtidor surtidor){
        if(this.dimL < this.surtidores.length){
            this.dimL++;
            this.surtidores[this.dimL]= surtidor;
        }
        return true;
    }
    
    public void generarVenta(int surtidor, String dni, int cantLitros, String metodoPago){
        this.surtidores[surtidor].generarVenta(dni, cantLitros, metodoPago);
    }
    
    public int surtidorMayorMonto(){
        double montoMax = -999;
        int surtMax = 0;
        for(int i = 1; i <= this.dimL; i++ ){
            if(montoMax < this.surtidores[i].obtenerMonto()){
                montoMax = this.surtidores[i].obtenerMonto();
                surtMax = i;
            }
                
        }
        return surtMax;
    }
    
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Surtidor[] getSurtidores() {
        return surtidores;
    }

    public void setSurtidores(Surtidor[] surtidores) {
        this.surtidores = surtidores;
    }

    @Override
    public String toString() {
        String aux= "";
        for(int i = 1; i <= this.dimL ; i++){
            aux +=  "Surtidor" + i + " "+ this.surtidores[i].toString()+ "\n";
        }     
        return aux;
    }
}

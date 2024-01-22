/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial5Objetos;

/**
 *
 * @author Piggypink
 */
public abstract class Sistema {
    private Solicitud[] solicitudes;
    private int dimL;
    
    public Sistema(int n) {
        this.solicitudes = new Solicitud[n];
        this.dimL = 0;
    }
    
    public void agregarSolicitud(Solicitud solicitud){
        if(this.dimL < this.solicitudes.length){
            this.solicitudes[this.dimL] = solicitud;
            this.dimL++;
        }
    }
    
    public Solicitud obtenerSolicitud(int i){
        return this.solicitudes[i];
    }
    
    public Solicitud[] getSolicitudes() {
        return solicitudes;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }   
    


    public void setSolicitudes(Solicitud[] solicitudes) {
        this.solicitudes = solicitudes;
    }
    
    public abstract void otorgarSubsidio(double monto);

    @Override
    public String toString() {
        String aux = "";
        for(int i = 0; i < this.dimL; i++){
            aux += this.solicitudes[i].toString() + "\n";
        }
        
        return aux;
        
    }
    
    
    
}

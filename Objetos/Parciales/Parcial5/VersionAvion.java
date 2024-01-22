/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial5Objetos;

/**
 *
 * @author Piggypink
 */
public class VersionAvion extends Sistema{

    public VersionAvion(int n) {
        super(n);
    }
    
    @Override
    public void otorgarSubsidio(double monto) {
        Solicitud[] solicitudes = this.getSolicitudes();
        Solicitud solicitud = null;
        for(int i=0; i < this.getDimL(); i++){
            solicitud = solicitudes[i];
            double montoSolicitud = solicitud.getCostoPasajeIda() + solicitud.getCostoPasajeVuelta() + solicitud.getTasaEmbarque();
            if(montoSolicitud > monto)
                solicitud.setSubsidio(true);        
        }
    }
    
}

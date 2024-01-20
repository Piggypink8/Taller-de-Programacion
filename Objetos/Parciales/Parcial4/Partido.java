/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial4Objetos;

/**
 *
 * @author Piggypink
 */
public class Partido {
    private String local;
    private String visitante;
    private String resultado;

    public Partido(String local, String visitante) {
        this.local = local;
        this.visitante = visitante;
    }

    public Partido(String local, String visitante, String resultado) {
        this.local = local;
        this.visitante = visitante;
        this.resultado = resultado;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
}

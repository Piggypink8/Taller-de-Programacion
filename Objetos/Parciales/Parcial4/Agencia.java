/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial4Objetos;

/**
 *
 * @author Piggypink
 */
public class Agencia {
    private Partido[] partidos;
    private Apuesta[] apuestas;
    private int dimLP = 0;
    private int dimLA = 0;

    public Agencia() {
        this.partidos = new Partido[3];
        this.apuestas = new Apuesta[3];
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public Apuesta[] getApuestas() {
        return apuestas;
    }

    public int getDimLP() {
        return dimLP;
    }

    public int getDimLA() {
        return dimLA;
    }

    
    public int agregarPartido(Partido partido){
        int id = 0;
        if(this.dimLP < this.partidos.length){
            this.partidos[this.dimLP] = partido;
            id = this.dimLP;
            this.dimLP++;
        }
        return id;
    }
    
    public void agregarApuesta(Apuesta apuesta){
        if(this.dimLA < this.apuestas.length){
            this.apuestas[this.dimLA] = apuesta;
            this.dimLA++;
        }
    }
    
    public void ingresarResultado(int id, String resultado){
        this.partidos[id].setResultado(resultado);
    }
    
    public void cerrarApuestas(){
        double monto = 0;
        Apuesta apuesta = null;
        for(int i=0; i < this.dimLA; i++){
            apuesta  = this.apuestas[i];
            String resultado = this.partidos[apuesta.getId()].getResultado();
            if(resultado.equals(apuesta.getResultado()))
                monto = apuesta.getMonto() + ( apuesta.getMonto() * apuesta.getFactorDePago(resultado));
            System.out.println("Nombre: "+ apuesta.getNombre() +", DNI:  "+ apuesta.getDni() + ", dinero ganado: " + monto);
        }
    }
    
    public void limpiarSistema(){
        for(int i=0; i<this.getDimLP(); i++)
            this.partidos[i] = null;
        
        for(int i=0; i<this.getDimLA(); i++)
            this.apuestas[i] = null;
        
        this.dimLA = 0;
        this.dimLP = 0;
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Parcial4Objetos;

/**
 *
 * @author Piggypink
 */
public class Parcial4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Partido partido1 = new Partido("River", "Boca"); // 0
        Partido partido2 = new Partido("Racing", "San Lorenzo"); // 1
        Partido partido3 = new Partido("Newells", "Velez"); // 2
        Partido partido4 = new Partido("Chacarita", "Almagro"); // 3
        
        Apuesta apuesta1 = new Apuesta("Brian", "29043212", 3, "empate", 500);
        Apuesta apuesta2 = new Apuesta("Joel", "31324665", 2, "victoria local", 339.55);
        Apuesta apuesta3 = new Apuesta("Sergio", "2954232", 0, "victoria visitante", 789.3);
        Apuesta apuesta4 = new Apuesta("Manuel", "34323211", 2, "victoria visitante", 8000);
        Apuesta apuesta5 = new Apuesta("Marino", "29452311", 3, "victoria visitante", 3235);
        Apuesta apuesta6 = new Apuesta("Julio", "20129021", 1, "empate", 100);
        Apuesta apuesta7 = new Apuesta("Ezequiel", "29564311", 1, "empate", 6524);
        Apuesta apuesta8 = new Apuesta("Ivan", "87654328", 1, "victoria local", 1283);
        Apuesta apuesta9 = new Apuesta("Federico", "28665113", 1, "victoria visitante", 600.43);
        
        Agencia agencia = new Agencia();
        
        //agregar partidos
        agencia.agregarPartido(partido1);
        agencia.agregarPartido(partido2);
        agencia.agregarPartido(partido3);
        agencia.agregarPartido(partido4);
        
        //agregar apuestas
        agencia.agregarApuesta(apuesta1);
        agencia.agregarApuesta(apuesta2);
        agencia.agregarApuesta(apuesta3);
        agencia.agregarApuesta(apuesta4);
        agencia.agregarApuesta(apuesta5);
        agencia.agregarApuesta(apuesta6);
        agencia.agregarApuesta(apuesta7);
        agencia.agregarApuesta(apuesta8);
        agencia.agregarApuesta(apuesta9);
        
        // ingresar resultados
        agencia.ingresarResultado(0, "empate");
        agencia.ingresarResultado(1, "victoria local");
        agencia.ingresarResultado(2, "victoria visitante");
        agencia.ingresarResultado(3, "empate");
        
        // cerrar apuestas
        agencia.cerrarApuestas();
        
        // limpiar sistema
        agencia.limpiarSistema();
    }
    
}

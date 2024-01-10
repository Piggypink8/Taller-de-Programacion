/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial1Objetos;

/**
 *
 * @author Piggypink
 */
public class Surtidor {
    private String combustible;
    private double precioLitro;
    private Venta[] ventas;
    private int dimL = 0;
    
    public Surtidor(String combustible, double precioLitro,int v) {
        this.combustible = combustible;
        this.precioLitro = precioLitro;
        this.ventas = new Venta[v];
    }
    
    public void generarVenta(String dni, int cantLitros, String metodoPago){
        Venta venta = new Venta(dni, cantLitros, (cantLitros*this.getPrecioLitro()), metodoPago);
        this.agregarVenta(venta);
    }
    
    public double obtenerMonto(){
        double monto = 0;
        for(int i = 1; i <= this.dimL; i++){
            if(this.ventas[i].metodoPago.equals("Efectivo"))
                monto += this.ventas[i].getMonto();
        }
        return monto;
    }
    
    public void agregarVenta(Venta venta){
        if(this.dimL < this.ventas.length) {
            this.dimL++;
            this.ventas[this.dimL] = venta;
        }
    }
    
    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }

    public double getPrecioLitro() {
        return precioLitro;
    }

    public void setPrecioLitro(double precioLitro) {
        this.precioLitro = precioLitro;
    }

    public Venta[] getVentas() {
        return ventas;
    }

    public void setVentas(Venta[] ventas) {
        this.ventas = ventas;
    }

    @Override
    public String toString() {
        String aux =  "combustible=" + combustible + ", precioLitro=" + precioLitro + "dimL=" + dimL + ", ventas=" ;
        for(int i = 1; i <= this.dimL ; i++){
            aux += this.ventas[i].toString()+ " ";
        }
        return aux + '}';
    }   
    
}

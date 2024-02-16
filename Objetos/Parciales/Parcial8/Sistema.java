/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial8Objetos;

/**
 *
 * @author Sandra
 */
public class Sistema {
    private Paciente[][] pacientes;

    public Sistema() {
        this.pacientes = new Paciente[5][6];
    }

    public Paciente[][] getPacientes() {
        return pacientes;
    }

    public void setPacientes(Paciente[][] pacientes) {
        this.pacientes = pacientes;
    }
    
    public void agregarPaciente(Paciente p,int dia, int turno){
        this.pacientes[dia][turno] = p;
    }
    // 2. I)
    public int agendarPrimerDiaLibre(Paciente p,int turno){
       boolean ok = false;
       int i = 0;
       while((i < 5) & (!ok)){
            if(this.pacientes[i][turno] == null){
                this.pacientes[i][turno] = p;
                ok = true;
            } else{ 
                i++;
            }
       }
       
       return i;
    }
    
    // 2. II)
    public void liberarTurno(String nombre,int dia){
        boolean ok = false;
        int i = 0;
        while((i < 6) & (!ok)){
            if(this.pacientes[dia][i] != null)
                 if(this.pacientes[dia][i].getNombre().equals(nombre));
                    this.pacientes[dia][i] = null;
            i++;
        }
    }
    
    // 2. III)
    public int cantTurnosAgendadosPor(String nombre){
        int cant = 0;
        for(int i = 0; i < this.pacientes.length; i++){
            for(int j = 0; j < this.pacientes[i].length; j++){
                if(this.pacientes[i][j] != null)
                   if(this.pacientes[i][j].getNombre().equals(nombre))
                       cant++;
            }
        }
        return cant;
    }
    
    public boolean tieneTurnoAgendado(Paciente p,int dia){
        boolean ok = false;
        int i = 0;
        while((i < 6) & (!ok)){
            if(this.pacientes[dia][i] != null)
                ok = this.pacientes[dia][i].equals(p);
            i++;
        }
        return ok;
    }
    
    public void liberarPaciente(Paciente p){
        for(int i = 0; i < this.pacientes.length; i++){
            for(int j = 0; j < this.pacientes[i].length; j++){
                if(this.pacientes[i][j] != null)
                    if(this.pacientes[i][j].equals(p))
                        this.pacientes[i][j] = null;
            }
        }
    }

    @Override
    public String toString() {
        String aux = "Sistema {" + "pacientes= ";
        for(int i = 0; i < this.pacientes.length; i++){
            for(int j = 0; j < this.pacientes[i].length; j++){
                if(this.pacientes[i][j] != null)
                   aux += this.pacientes[i][j].toString() + " \n";
            }
        }
        
        return aux;
    }
    
    
}
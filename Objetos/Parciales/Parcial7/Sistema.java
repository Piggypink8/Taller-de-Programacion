/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial7Objetos;

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
    
    public boolean tieneTurnoAgendado(Paciente p,int dia){
        int i = 0;
        while((i < 6) & (!this.pacientes[dia][i].equals(p))){
            System.out.println(i);
            i++;
        }
        return this.pacientes[dia][i].equals(p);
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
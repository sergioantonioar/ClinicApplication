package Estructura.Paciente;

import java.io.Serializable;
import Modelo.Paciente;

public class Nodo implements Serializable{
    
    public Paciente pac;
    
    public Nodo enlace;
    
    public Nodo(Paciente pac){
        this.pac = pac;
        enlace = this; 
    }
}
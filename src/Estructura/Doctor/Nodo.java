package Estructura.Doctor;

import Modelo.Doctor;
import java.io.Serializable;


public class Nodo implements Serializable{
    
    private Doctor doctor;
    private Nodo sig;

    public Nodo(Doctor doctor) {
        this.doctor = doctor;
        this.sig = null;
    }

    public Doctor getdoctor() {return doctor;}

    public void setdoctor(Doctor doctor) {this.doctor = doctor;}

    public Nodo getSig() {return sig;}

    public void setSig(Nodo sig) {this.sig = sig;}  
}

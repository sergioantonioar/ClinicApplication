package Modelo;

import java.io.Serializable;

public class Paciente implements Serializable{
    
    private String dni;
    
    private String nombres;
    
    private String telf;
    
    private int edad;
    
    private String direccion;
    
    private String genero;
    
    private String fechaNac;
    

    
    public Paciente(){}
    
    public Object[] Registro(int num){
        Object[] fila;
        fila = new Object[]{num,dni,nombres,telf,edad,direccion,genero,fechaNac};
        return fila;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getTelf() {
        return telf;
    }
    public void setTelf(String telf) {
        this.telf = telf;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "Paciente{" + "dni=" + dni + ", nombres=" + nombres + ", telf=" + telf + ", edad=" + edad + ", direccion=" + direccion + ", genero=" + genero + ", fechaNac=" + fechaNac + '}';
    }

}

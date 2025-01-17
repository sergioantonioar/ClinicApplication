package Modelo;

import java.io.Serializable;

public class Especialidad implements Serializable{
    
    private String codigo;
    private String Nombre;

    public Especialidad() {}
    
    public Object[] Registrar(int num){
        Object[] fila={num,codigo,Nombre};
        return fila;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        return "Especialidad{" + "id=" + codigo + ", tipo=" + Nombre + '}';
    }    
}
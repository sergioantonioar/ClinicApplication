package Estructura.Doctor;

import Modelo.Doctor;
import java.io.Serializable;

public class EnlazeNodo implements Serializable{
    private Nodo ini;
    private Nodo fin;
    public EnlazeNodo(){
        this.ini=null;
        this.fin=null;
    }
    
    public void ActualizarDoctor(Nodo actual,Doctor empleadosActualizado){
        actual.setdoctor(empleadosActualizado);
    }
    
    public void EliminarDoctor(Nodo actual){
        Nodo anterio=ini;
        while (anterio.getSig()!=actual && anterio.getSig()!=null) {            
            anterio=anterio.getSig();
        }
        if(actual!=null){
            if(ini==actual){
                ini=actual.getSig();
            }else{
                anterio.setSig(actual.getSig());
            }
        }
    }
    
    public void AgregarNodoInicio(Nodo Nuevo){
        if(ini==null && fin==null){
            ini=Nuevo;
            fin=Nuevo;
        }else{
            Nuevo.setSig(ini);
            ini=Nuevo;
        }
    }
    
    public void AgregarNodoFinal(Nodo Nuevo){
        if(ini==null && fin==null){
            ini=Nuevo;
            fin=Nuevo;
        }else{
            fin.setSig(Nuevo);
        }
            fin=Nuevo;
            fin.setSig(null);
    }
    
    public boolean VerificarDuplicados(Doctor doctor){
        Nodo aux=ini;
        while(aux!=null){
            if(aux.getdoctor().getCodigo().equals(doctor.getCodigo()) || aux.getdoctor().getDni().equals(doctor.getDni())){
                return true;
            }
            aux=aux.getSig();
        }
        return false;
    }
    
    public Nodo BuscarCodigo(String codigo){
        Nodo aux=ini;
        while (aux!=null) {            
            if(aux.getdoctor().getCodigo().equalsIgnoreCase(codigo)){
                return aux;
            }
            aux=aux.getSig();
        }
        return null;
    }
    
    public Nodo Buscar_Doctor_Sesion(String codigo,String dni){
        Nodo aux=ini;
        while (aux!=null) {            
            if(aux.getdoctor().getCodigo().equalsIgnoreCase(codigo) && aux.getdoctor().getDni().equalsIgnoreCase(dni)){
                return aux;
            }
            aux=aux.getSig();
        }
        return null;
    }
    
    public boolean VerificarSesionDoctor(String codigo, String dni){
        Nodo aux = ini;
        while (aux != null) { 
            if(aux.getdoctor().getCodigo().equals(codigo) && aux.getdoctor().getDni().equals(dni)){
                return true;
            }
            aux = aux.getSig(); 
        }
        return false; 
    }

    public Nodo getIni() {
        return ini;
    }

    public void setIni(Nodo ini) {
        this.ini = ini;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }
}

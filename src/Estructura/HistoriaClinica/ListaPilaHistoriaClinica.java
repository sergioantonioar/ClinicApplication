package Estructura.HistoriaClinica;

import Modelo.HistoriaClinica;
import Persistencia.Persistencia_HistoriaClinica;
import Procesos.Mensajes;
import java.io.Serializable;
import java.util.Stack;

public class ListaPilaHistoriaClinica implements Serializable{
    
    private Stack<HistoriaClinica>Pila;
    private Persistencia_HistoriaClinica persistencia;

    public ListaPilaHistoriaClinica() {
        persistencia=new Persistencia_HistoriaClinica();
        Pila=persistencia.RecupereHistoriaClinica();
    }
    
    private void GuardarCambios(){
        persistencia.GuardarHistoriaClinica(Pila);
    }
    
    public void AgregarPila(HistoriaClinica historiaClinica){
        Pila.push(historiaClinica);
        GuardarCambios();
    }
    
    public void Despilar(){
        Pila.pop();
        GuardarCambios();
    }
    
    public void VerPrimerElemento(){
        Mensajes.LeerMensaje(Pila.firstElement().toString());
    }
    
    public void VerUltimoElemnento(){
        Mensajes.LeerMensaje(Pila.peek().toString());
    }
    
    public HistoriaClinica BuscarPilaHistoriaClinica(String codigo){
        for (HistoriaClinica historiaClinica : Pila) {
            if(historiaClinica.getCodigo().contains(codigo)){
                return historiaClinica;
            }
        }
        Mensajes.LeerMensaje("No se encontro la pila");
        return null;
    }
    
    public boolean Detector_Duplicados(String dni_paciente){
        for (HistoriaClinica historiaClinica : Pila) {
            if(historiaClinica.getPaciente().getDni().equals(dni_paciente)){
                return true;
            }
        }
        return false;
    }
    
    public HistoriaClinica BuscarPilaHistoriaClinica_Paciente(String DNI_paciente) {
        for (HistoriaClinica historiaClinica : Pila) {
            if (historiaClinica.getPaciente().getDni().equals(DNI_paciente)) {
                return historiaClinica;
            }
        }
        Mensajes.LeerMensaje("No se encontro la pila");
        return null;
    }
    
        
    public HistoriaClinica BuscarHistoria_Imprimir(String DNI_paciente,String Nombre_paciente) {  
        for (HistoriaClinica historiaClinica : Pila) {
            if (historiaClinica.getPaciente().getDni().equals(DNI_paciente)&&
                    historiaClinica.getPaciente().getNombres().equals(Nombre_paciente)) {
                return historiaClinica;
            }
        }
        Mensajes.LeerMensaje("No se encontro la pila");
        return null;
    }

    
    public void ActualizarPila(String codigo, HistoriaClinica historiaActualizar) {
        for (int i = 0; i < Pila.size(); i++) {
            if (Pila.get(i).getCodigo().equals(codigo)) {
                Pila.set(i, historiaActualizar); 
                GuardarCambios(); 
                Mensajes.LeerMensaje("Historia clínica actualizada correctamente.");
                return;
            }
        }
        Mensajes.LeerMensaje("No se encontró la historia clínica con el código especificado.");
    }
    
    public void ActualizarPila_Atencion(String codigo, HistoriaClinica historiaActualizar) {
        for (int i = 0; i < Pila.size(); i++) {
            if (Pila.get(i).getCodigo().equals(codigo)) {
                Pila.set(i, historiaActualizar); 
                GuardarCambios(); 
                return;
            }
        }
        Mensajes.LeerMensaje("Hubo un error al juntar la atencion con Historia Clinica");
    }

    public Stack<HistoriaClinica> getPila() {
        return Pila;
    }
    
    
}

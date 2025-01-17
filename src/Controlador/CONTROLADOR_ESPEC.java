package Controlador;

import Estructura.Especialidad.ArrayEspecialidad;
import Modelo.Especialidad;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_ESPEC;
import Vista.GUIF_AGREGAR_ESPEC;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CONTROLADOR_ESPEC implements ActionListener {

    private GUIF_AGREGAR_ESPEC vista;
    private PROCESOS_GUI_ESPEC procesos;
    private ArrayEspecialidad lista;
    private String codigoEspec;

    public CONTROLADOR_ESPEC() {
        vista = new GUIF_AGREGAR_ESPEC();
        procesos = new PROCESOS_GUI_ESPEC(vista);
        lista = new ArrayEspecialidad();
        procesos.Presentacion();
        procesos.MostrarTabla(lista);
        vista.BTN_ACTUALIZAR.addActionListener(this);
        vista.BTN_AÑADIR.addActionListener(this);
        vista.BTN_BUSCAR.addActionListener(this);
        vista.BTN_ELIMINAR.addActionListener(this);
        vista.BTN_ORDENAR.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.BTN_ACTUALIZAR) {
            ModificarEspecialidad();
        } else if (e.getSource() == vista.BTN_AÑADIR) {
            AgregarEspecialidad();
        } else if (e.getSource() == vista.BTN_BUSCAR) {
            BuscarEspecialidad();
        } else if (e.getSource() == vista.BTN_ELIMINAR) {
            EliminarEspecialidad();
        } else if (e.getSource() == vista.BTN_ORDENAR) {
            if ("Nombre".equals(vista.CBX_SELC_ORDEN.getSelectedItem())) {
                OrdenarPorNombres();
            }
        }
    }

    public void AgregarEspecialidad() {
        lista.AñadirEspecialidad(procesos.CrearEspecialidad());
        procesos.MostrarTabla(lista);
        procesos.limpiarEntradasEspecialidad();
    }

    public void EliminarEspecialidad() {
        lista.EliminarEspecialidad(lista.BuscarIndexEspecialidad(Mensajes.Escribir("Ingrese el codigo de la especialidad")));
        procesos.MostrarTabla(lista);
        procesos.limpiarEntradasEspecialidad();
    }

    public void BuscarEspecialidad() {
        codigoEspec = Mensajes.Escribir("Ingrese el código de la especialidad a buscar");
        int index = lista.BuscarIndexEspecialidad(codigoEspec);

        if (index >= 0) {
            Especialidad espec = lista.ObtenerEspecialidad(index);
            procesos.cargarEspecialidad(espec);
        } else {
            Mensajes.LeerMensaje("Especialidad con código " + codigoEspec + " no encontrada.");
        }
    }

    public void ModificarEspecialidad() {
        int index = lista.BuscarIndexEspecialidad(codigoEspec);
        Especialidad especModificada = procesos.CrearEspecialidad();

        // Paso 4: Actualizar la especialidad en el arreglo
        lista.ActualizarEspecialidad(index, especModificada);

        // Paso 5: Actualizar la tabla y limpiar el formulario
        procesos.MostrarTabla(lista);
        procesos.limpiarEntradasEspecialidad();
        //procesos.limpiarEntradasEspecialidad();
        Mensajes.LeerMensaje("Especialidad modificada exitosamente.");

    }
    public void OrdenarPorNombres(){
       lista.OrdenarPorNombre();
        procesos.MostrarTabla(lista);
    }

    public GUIF_AGREGAR_ESPEC getVista() {
        return vista;
    }

}

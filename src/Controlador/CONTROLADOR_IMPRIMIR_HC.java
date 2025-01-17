package Controlador;

import Estructura.Atencion.ArrayListAtencion;
import Estructura.HistoriaClinica.ListaPilaHistoriaClinica;
import Estructura.Paciente.EnlazeCircular;
import Modelo.*;
import Persistencia.Persistencia_Atencion;
import Persistencia.Persistencia_HistoriaClinica;
import Persistencia.Persistencia_Paciente;
import Procesos.Mensajes;
import Procesos.PROCESOS_GUI_IMPRIMIR_HC;
import Reportes.ReporteAtencion;
import Reportes.ReporteHistoriaClinica;
import Vista.GUIF_IMPRIMIR_HC;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class CONTROLADOR_IMPRIMIR_HC implements ActionListener {

    private GUIF_IMPRIMIR_HC vista;
    private PROCESOS_GUI_IMPRIMIR_HC procesos;
    private ListaPilaHistoriaClinica pilaHistoriaClinica;
    private ArrayListAtencion listaAtenciones;
    private ArrayList<Atencion> atenciones;
    private Persistencia_HistoriaClinica persistenciaHC;
    private Persistencia_Atencion persistencia;
    private Persistencia_Paciente persistPac;
    private EnlazeCircular pac;
    private Stack<HistoriaClinica> hc;

    private String TextArea = "";

    public CONTROLADOR_IMPRIMIR_HC() {

        vista = new GUIF_IMPRIMIR_HC();
        procesos = new PROCESOS_GUI_IMPRIMIR_HC(vista);
        pilaHistoriaClinica = new ListaPilaHistoriaClinica();
        listaAtenciones = new ArrayListAtencion();
        persistencia = new Persistencia_Atencion();
        persistPac = new Persistencia_Paciente();
        persistenciaHC = new Persistencia_HistoriaClinica();
        procesos.Presentacion();

        vista.BTN_IMPR_PDF.addActionListener(this);
        vista.BTN_IMPR_ATENPDF.addActionListener(this);
        vista.BTN_BUSCAR.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.BTN_BUSCAR) {
            BuscarHc();
        }
        if (e.getSource() == vista.BTN_IMPR_ATENPDF) {
            ImprimirAtenciones();
        }
        if (e.getSource() == vista.BTN_IMPR_PDF) {
            ImprimirHistoriasClinicas();
        }
    }

    public void BuscarHc() {

        String DniPaciente = procesos.getDniPaciente();
        String NombrePaciente = procesos.getNombrePaciente();

        HistoriaClinica hc = pilaHistoriaClinica.BuscarHistoria_Imprimir(DniPaciente, NombrePaciente);

        if (hc != null) {
            TextArea = hc.toString();
            procesos.CargarHistoriaClinica(TextArea);
        } else {
            Mensajes.LeerMensaje("No se encontro la historia clinica del paciente : " + NombrePaciente);
        }
    }

    public void ImprimirAtenciones() {
        // Obtener datos del paciente desde la vista
        String dniPaciente = procesos.getDniPaciente();
        String nombrePaciente = procesos.getNombrePaciente();

        // Verificar si se proporcionaron los datos
        if (dniPaciente.isEmpty() || nombrePaciente.isEmpty()) {
            Mensajes.LeerMensaje("Debe ingresar el DNI y el nombre del paciente.");
            return;
        }

        // Recuperar todas las atenciones y filtrar las del paciente
        atenciones = persistencia.RecupereAtenciones();
        ArrayList<Atencion> atencionesFiltradas = new ArrayList<>();
        for (Atencion atencion : atenciones) {
            if (atencion.getPaciente().getDni().equals(dniPaciente)
                    && atencion.getPaciente().getNombres().equalsIgnoreCase(nombrePaciente)) {
                atencionesFiltradas.add(atencion);
            }
        }

        // Verificar si el paciente tiene atenciones
        if (atencionesFiltradas.isEmpty()) {
            Mensajes.LeerMensaje("No se encontraron atenciones para el paciente con DNI: " + dniPaciente);
            return;
        }

        //crear reporte
        ReporteAtencion reporte = new ReporteAtencion(atencionesFiltradas);
        // Definir la ruta de la carpeta de reportes
        String carpetaReportes = "ReportesAtenciones";
        File carpeta = new File(carpetaReportes);

        // Crear la carpeta si no existe
        if (!carpeta.exists()) {
            if (carpeta.mkdir()) {
                System.out.println("Carpeta 'ReportesAtenciones' creada correctamente.");
            } else {
                System.out.println("No se pudo crear la carpeta 'ReportesAtenciones'.");
                return; // Salir si no se pudo crear la carpeta
            }
        }

        // Generar identificador aleatorio al nombre
        Random rand = new Random();
        int randId = rand.nextInt(1000);

        // Generar el reporte dentro de la carpeta
        String rutaPDF = carpetaReportes + "/ReporteAtencion_REP-" + String.format("%03d", randId) + ".pdf";

        reporte.generarDocAtenciones(rutaPDF);
        AbrirPdf(rutaPDF);
    }

    public void ImprimirHistoriasClinicas() {
        // Obtener datos del paciente desde la vista
        String dniPaciente = procesos.getDniPaciente();
        String nombrePaciente = procesos.getNombrePaciente();

        // Verificar si se proporcionaron los datos
        if (dniPaciente.isEmpty() || nombrePaciente.isEmpty()) {
            Mensajes.LeerMensaje("Debe ingresar el DNI y el nombre del paciente.");
            return;
        }

        // Buscar la historia clínica del paciente
        HistoriaClinica historiaClinica = pilaHistoriaClinica.BuscarHistoria_Imprimir(dniPaciente, nombrePaciente);

        // Verificar si la historia clínica fue encontrada
        if (historiaClinica == null) {
            Mensajes.LeerMensaje("No se encontró la historia clínica para el paciente con DNI: " + dniPaciente);
            return;
        }

        // Generar el reporte en PDF
        ReporteHistoriaClinica reporte = new ReporteHistoriaClinica(historiaClinica);

        // Definir la ruta de la carpeta de reportes
        String carpetaReportes = "ReportesHistoriasClinicas";
        File carpeta = new File(carpetaReportes);

        // Crear la carpeta si no existe
        if (!carpeta.exists()) {
            if (carpeta.mkdir()) {
                System.out.println("Carpeta 'ReportesHistoriasClinicas' creada correctamente.");
            } else {
                System.out.println("No se pudo crear la carpeta 'ReportesHistoriasClinicas'.");
                return; // Salir si no se pudo crear la carpeta
            }
        }

        // Generar identificador aleatorio al nombre del archivo
        Random rand = new Random();
        int randId = rand.nextInt(1000);

        // Generar el reporte dentro de la carpeta
        String rutaPDF = carpetaReportes + "/ReporteHistoriaClinica_REP-" + String.format("%03d", randId) + ".pdf";
        reporte.generarDocHistoriaClinica(rutaPDF);

        // Abrir automáticamente el archivo PDF
        AbrirPdf(rutaPDF);
    }

    // Abrir automaticamente el pdf
    public void AbrirPdf(String rutaPDF) {
        File archivoPDF = new File(rutaPDF);
        if (archivoPDF.exists()) {
            try {
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.OPEN)) {
                    desktop.open(archivoPDF);
                    System.out.println("Abriendo el archivo PDF...");
                } else {
                    System.out.println("Abrir archivos no está soportado en este sistema");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al intentar abrir el archivo PDF");
            }
        } else {
            System.out.println("El archivo PDF no fue encontrado");
        }
    }

    public GUIF_IMPRIMIR_HC getVista() {
        return vista;
    }

}

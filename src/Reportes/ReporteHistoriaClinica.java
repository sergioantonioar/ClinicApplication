package Reportes;

import Modelo.*;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.text.SimpleDateFormat;

/**
 *
 * @author SERGIO
 */
public class ReporteHistoriaClinica extends GeneradorPDF {

    private HistoriaClinica historiacli;
    private Font headerFont, tituloFont, textoFont, subrayadoFont;
    private SimpleDateFormat formatter;

    public ReporteHistoriaClinica(HistoriaClinica historiacli) {
        this.historiacli = historiacli;
        formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); //formateando Date
        
        //Fonts
        tituloFont = new Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));
        headerFont = new Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
        textoFont = new Font(FontFactory.getFont(FontFactory.TIMES_ROMAN, 12));
        subrayadoFont = new Font(FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, Font.UNDERLINE));
    }

    @Override
    protected void construirContenido(Document document) throws DocumentException {

        try {
            // Tabla para logos
            PdfPTable tabla = new PdfPTable(2);
            tabla.setWidthPercentage(100); // Ocupar todo el ancho de pagina
            tabla.setWidths(new float[]{1, 1}); // proporción de las columnas

            // Logo Uni
            Image imagenUni = Image.getInstance(getClass().getResource("../Recursos/UtpLogo.png"));
            imagenUni.scaleToFit(100, 100); // Ajustar tamaño de la imagen
            PdfPCell celdaUni = new PdfPCell(imagenUni);
            celdaUni.setBorder(PdfPCell.NO_BORDER);
            celdaUni.setHorizontalAlignment(PdfPCell.ALIGN_LEFT);

            // Logo clínica
            Image imagenClin = Image.getInstance(getClass().getResource("../Recursos/logoclinica200.png"));
            imagenClin.scaleToFit(100, 100);

            PdfPCell celdaClin = new PdfPCell(imagenClin);
            celdaClin.setBorder(PdfPCell.NO_BORDER);
            celdaClin.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);

            tabla.addCell(celdaUni);
            tabla.addCell(celdaClin);

            document.add(tabla);

        } catch (Exception e) {
            System.out.println("Error: URL de la imagen no válida.");
            e.printStackTrace();
        }

        Paragraph titulo = new Paragraph("HISTORIA CLINICA", tituloFont);
        titulo.setAlignment(Element.ALIGN_CENTER);
        document.add(titulo);
        document.add(new Paragraph(" "));

        Paragraph dp = new Paragraph("DATOS PERSONALES:", subrayadoFont);
        document.add(dp);
        document.add(new Paragraph(" "));

        Paragraph codHC = new Paragraph();
        codHC.add(new Chunk("Codigo de Historia: ", headerFont));
        codHC.add(new Chunk(historiacli.getCodigo(),textoFont));
        document.add(codHC);
        
        Paragraph dniInfo = new Paragraph();
        dniInfo.add(new Chunk("Dni: ", headerFont));
        dniInfo.add(new Chunk(historiacli.getPaciente().getDni(),textoFont));
        document.add(dniInfo);
        
        Paragraph nombInfo = new Paragraph();
        nombInfo.add(new Chunk("Nombres: ", headerFont));
        nombInfo.add(new Chunk(historiacli.getPaciente().getNombres(),textoFont));
        document.add(nombInfo);

        Paragraph telfInfo = new Paragraph(); // Crear un párrafo único
        telfInfo.add(new Chunk("Telef: ", headerFont)); // Agregar el texto con estilo subrayado
        telfInfo.add(new Chunk(historiacli.getPaciente().getTelf(), textoFont)); // Agregar el texto del número de teléfono con fuente estándar
        document.add(telfInfo); // Añadir el párrafo al documento
        
        Paragraph fnInfo = new Paragraph();
        fnInfo.add(new Chunk("Fecha de Nacimiento: ", headerFont));
        fnInfo.add(new Chunk(historiacli.getPaciente().getFechaNac(),textoFont));
        document.add(fnInfo);
        
        Paragraph edadInfo = new Paragraph();
        edadInfo.add(new Chunk("Edad: ",headerFont));
        edadInfo.add(new Chunk(String.valueOf(historiacli.getPaciente().getEdad()),textoFont));
        document.add(edadInfo);
        
        Paragraph sexInfo = new Paragraph();
        sexInfo.add(new Chunk("Sexo: ",headerFont));
        sexInfo.add(new Chunk(historiacli.getPaciente().getGenero(),textoFont));
        document.add(sexInfo);
        
        Paragraph direcInfo = new Paragraph();
        direcInfo.add(new Chunk("Domicilio: ",headerFont));
        direcInfo.add(new Chunk(historiacli.getPaciente().getDireccion(),textoFont));
        document.add(direcInfo);
        
        Paragraph fecEmiInfo = new Paragraph();
        fecEmiInfo.add(new Chunk("Fecha de emisión: ", headerFont));
        fecEmiInfo.add(new Chunk(formatter.format(historiacli.getFecha()),textoFont));
        document.add(fecEmiInfo);
        
        document.add(new Paragraph(" "));
        Paragraph ant = new Paragraph("ANTECEDENTES:", subrayadoFont);
        document.add(ant);
        document.add(new Paragraph(" "));
        
        Paragraph antPer = new Paragraph();
        antPer.add(new Chunk("Personales: ",headerFont));
        antPer.add(new Chunk(historiacli.getAtencedentePersonales(),textoFont));
        document.add(antPer);
        
        Paragraph antFam = new Paragraph();
        antFam.add(new Chunk("Familiares: ",headerFont));
        antFam.add(new Chunk(historiacli.getAtencedenteFamiliares(),textoFont));
        document.add(antFam);
        
        document.add(new Paragraph(" "));
        Paragraph detalles = new Paragraph("DETALLES MÉDICOS:", subrayadoFont);
        document.add(detalles);
        document.add(new Paragraph(" "));
        
        Paragraph alergias = new Paragraph();
        alergias.add(new Chunk("Alergias: ",headerFont));
        alergias.add(new Chunk(historiacli.getAlergias(),textoFont));
        document.add(alergias);
        
        Paragraph vacun = new Paragraph();
        vacun.add(new Chunk("Vacunas: ",headerFont));
        vacun.add(new Chunk(historiacli.getVacunas(),textoFont));
        document.add(vacun);
        
        Paragraph medicam = new Paragraph();
        medicam.add(new Chunk("Medicamentos Actuales: ",headerFont));
        medicam.add(new Chunk(historiacli.getMedicamentosActuales(),textoFont));
        document.add(medicam);
        
        document.add(new Paragraph(" "));
        Paragraph ht = new Paragraph("HÁBITOS Y TRATAMIENTOS:", subrayadoFont);
        document.add(ht);
        document.add(new Paragraph(" "));
        
        Paragraph habitos = new Paragraph();
        habitos.add(new Chunk("Hábitos: ", headerFont));
        habitos.add(new Chunk(historiacli.getHabitos(),textoFont));
        document.add(habitos);
        
        Paragraph tratam = new Paragraph();
        tratam.add(new Chunk("Tratamientos Previos: ", headerFont));
        tratam.add(new Chunk(historiacli.getTratamientosPrevios(),textoFont));
        document.add(tratam);
        
        document.add(new Paragraph(" "));
        Paragraph histEx = new Paragraph("HISTORIAL Y EXÁMENES:", subrayadoFont);
        document.add(histEx);
        document.add(new Paragraph(" "));
        
        Paragraph exrel = new Paragraph();
        exrel.add(new Chunk("Exámenes Realizados: ", headerFont));
        exrel.add(new Chunk(historiacli.getExamanesRealizados(),textoFont));
        document.add(exrel);
        
        Paragraph histQui = new Paragraph();
        histQui.add(new Chunk("Historial Quirúrgico: ", headerFont));
        histQui.add(new Chunk(historiacli.getHistorialQuirurjica(),textoFont));
        document.add(histQui);
        
    }

}

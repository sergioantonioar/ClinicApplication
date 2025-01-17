package Reportes;

import Modelo.Atencion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPCell;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author SERGIO
 */
public class ReporteAtencion extends GeneradorPDF {

    private ArrayList<Atencion> atenciones;
    private SimpleDateFormat sdf;

    public ReporteAtencion(ArrayList<Atencion> atenciones) {
        this.atenciones = atenciones;
        sdf = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    protected void construirContenido(Document document) throws DocumentException {
        //fuentes
        Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
        Font textoFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
        Font headerFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12);

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

        //Atenciones
        document.add(new Paragraph("Reporte de Atenciones", tituloFont));
        document.add(new Paragraph(" "));

//        //tabla
//        PdfPTable tabla = new PdfPTable(9);
//        tabla.setWidthPercentage(100);
//        tabla.setSpacingBefore(10f);
//        tabla.setSpacingAfter(10f);
//
//        String[] headers = {"Cod.", "Paciente", "Doctor", "Motivo", "Obs.", "Diagnost.", "Tratam.", "Espec.", "Fecha"};
//        for (String header : headers) {
//            PdfPCell cell = new PdfPCell(new Paragraph(header, headerFont));
//            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
//            tabla.addCell(cell);
//        }
//
//        //Llenado de datos
//        for (Atencion atencion : atenciones) {
//            tabla.addCell(new Paragraph(atencion.getCodigo(), textoFont));
//            tabla.addCell(new Paragraph(atencion.getPaciente().getNombres(), textoFont));
//            tabla.addCell(new Paragraph(atencion.getDoctor().getNombres(), textoFont));
//            tabla.addCell(new Paragraph(atencion.getMotivo(), textoFont));
//            tabla.addCell(new Paragraph(atencion.getObservacion(), textoFont));
//            tabla.addCell(new Paragraph(atencion.getDiagnostico(), textoFont));
//            tabla.addCell(new Paragraph(atencion.getTratamiento(), textoFont));
//            tabla.addCell(new Paragraph(atencion.getEspecialidad_atencion().getNombre(), textoFont));
//            tabla.addCell(new Paragraph(sdf.format(atencion.getFecha()), textoFont));
//        }
//
//        //añadir la tabla al doc
//        document.add(tabla);
        PdfPTable tabla = new PdfPTable(9);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10f);
        tabla.setSpacingAfter(10f);

        String[] headers = {"Cod.", "Paciente", "Doctor", "Motivo", "Obs.", "Diagnost.", "Tratam.", "Espec.", "Fecha"};
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Paragraph(header, headerFont));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);

            // Aplicar padding a las celdas de los encabezados
            cell.setPaddingTop(5f);    // Padding superior
            cell.setPaddingBottom(5f); // Padding inferior
            cell.setPaddingLeft(5f);   // Padding izquierdo
            cell.setPaddingRight(5f);  // Padding derecho

            tabla.addCell(cell);
        }

        //Llenado de datos
        for (Atencion atencion : atenciones) {
            
            //Crear celdas con padding
            PdfPCell cell;

            cell = new PdfPCell(new Paragraph(atencion.getCodigo(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(atencion.getPaciente().getNombres(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(atencion.getDoctor().getNombres(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(atencion.getMotivo(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(atencion.getObservacion(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(atencion.getDiagnostico(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(atencion.getTratamiento(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(atencion.getEspecialidad_atencion().getNombre(), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);

            cell = new PdfPCell(new Paragraph(sdf.format(atencion.getFecha()), textoFont));
            cell.setPaddingTop(6f);
            cell.setPaddingBottom(6f);
            tabla.addCell(cell);
        }

        // Agregar al doc
        document.add(tabla);

    }

}

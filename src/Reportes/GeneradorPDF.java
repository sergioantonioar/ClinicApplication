package Reportes;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

public abstract class GeneradorPDF {

    public void generarDocAtenciones(String ruta) {
        Document documento = new Document(PageSize.A4.rotate(), 36, 36, 36, 36);
        try {
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Llama al método abstracto para que cada reporte defina su contenido
            construirContenido(documento);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }
    
    public void generarDocHistoriaClinica(String ruta) {
        Document documento = new Document(PageSize.A4, 36, 36, 30, 30);
        try {
            PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

            // Llama al método abstracto para que cada reporte defina su contenido
            construirContenido(documento);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            documento.close();
        }
    }

    protected abstract void construirContenido(Document document) throws DocumentException;
}

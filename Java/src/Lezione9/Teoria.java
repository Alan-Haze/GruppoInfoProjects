package Lezione9;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import com.itextpdf.*;

public class Teoria {
	private static String FILE = "outPdf/Lezione9/Test1.pdf";
	private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Document document = new Document();

	public static void main(String[] args, Document document) {
		// TODO Auto-generated method stub

		try {

			document.open();

			aggiungiMetadati(document);
			aggiungiPrefazione(document);
			aggiungiContenuto(document);
			document.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		document.close();

	}

	private static void aggiungiContenuto(Document document) {
		Chapter chapter = new Chapter(new Paragraph("Ciao"), 1);
		Paragraph sectionParagraph = new Paragraph("Sezione 1");
		Section section = chapter.addSection(sectionParagraph);
		section.add(new Paragraph("Paragrafo1"));
		sectionParagraph = new Paragraph("Sezione 2");

		creaTabella(section);

		PdfPTable tabella = new PdfPTable(4);

		PdfPCell c1 = new PdfPCell(new Phrase("Cognome"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);
		c1 = new PdfPCell(new Phrase("Nome"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);
		c1 = new PdfPCell(new Phrase("Data"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);
		c1 = new PdfPCell(new Phrase("Targa"));
		c1.setHorizontalAlignment(Element.ALIGN_CENTER);
		c1.setGrayFill(0.8f);
		tabella.addCell(c1);

		// se dati sforano va a ripetere i titoli delle colonne
		tabella.setHeaderRows(1);

		tabella.addCell("gigiogio");
		tabella.addCell("gigiogio");
		tabella.addCell("gigiogio");
		tabella.addCell("gigiogio");
		tabella.addCell("gigiogio");
		tabella.addCell("gigiogio");
		tabella.addCell("gigiogio");

		section.add(tabella);

	}

	public static String[] leggiFile(String path) {
		ArrayList<String> campi = new ArrayList<>();
		String[] file;
		String Riga = "";
		try {
			FileReader fr = new FileReader(path);
			BufferedReader reader = new BufferedReader(fr);
			while ((Riga = reader.readLine()) != null) {
				String[] record = Riga.split("-");
				for (int i = 0; i < record.length; i++) {
					campi.add(record[i]);
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		file = new String[campi.size()];
		for (int i = 0; i < file.length; i++) {
			file[i] = campi.get(i);
		}

		return file;
	}

	private static void creaTabella(Section section) {
		// TODO Auto-generated method stub

	}

	private static void aggiungiPrefazione(Document document) throws DocumentException {
		// TODO Auto-generated method stub
		Paragraph prefazione = new Paragraph();
		prefazione.add(new Paragraph("Titolo del documento", bigFont));
		aggiungiLineaVuota(prefazione, 1);
		document.add(prefazione);
		// document.newPage();
	}

	private static void aggiungiLineaVuota(Paragraph paragraph, int number) {
		// TODO Auto-generated method stub
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private static void aggiungiMetadati(Document document) {
		// TODO Auto-generated method stub
		document.addTitle("es9");
		document.addSubject("ciao");
		document.addKeywords("Java,pdf,tet");
		document.addCreator("Alan");
		document.addAuthor("gruppoInfo");

	}

}

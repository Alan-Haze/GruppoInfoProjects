package Lezione9;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Es9 {
	private static String FILE = "src/Lezione9/Test1.pdf";
	private static Font bigFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static Font smallFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
	private static Font fTabella = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
	private static Font testo = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

	private static Document document = new Document();
	private static PdfWriter writer;

	static String[] multe = Read("out/Esercizio 9/Multe.txt");
	static String[] anagraficaMulte = Read("out/Esercizio 9/AnagraficaMulte.txt");
	static String[] targhe = Read("out/Esercizio 9/Targhe.txt");

	public static void main(String[] args) {

		Confronta(multe, anagraficaMulte, targhe);

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(FILE));
			document.open();
			FinalDocumentWith(multe, anagraficaMulte, targhe);
		} catch (Exception e) {
			e.printStackTrace();
		}
		document.close();
	}

	private static void FinalDocumentWith(String[] multe, String[] anagraficaMulte, String[] targhe)
			throws DocumentException {
		Paragraph paragrafo;
		PdfPTable tabella;
		PdfPCell cella;
		PdfContentByte cb;
		int importo;
		int contaPagine = 0;

		for (int i = 0; i < anagraficaMulte.length; i += 3) {
			document.newPage();
			contaPagine++;
			int contaRighe = 0;
			importo = Integer.parseInt(anagraficaMulte[i + 2]);

			// titolo
			tabella = new PdfPTable(2);
			tabella.setWidthPercentage(100);

			cella = new PdfPCell();
			cella.disableBorderSide(4);
			cella.disableBorderSide(8);
			tabella.addCell(cella);

			cella = new PdfPCell(new Phrase("CITTÀ DI TORINO", bigFont));
			cella.setHorizontalAlignment(Element.ALIGN_CENTER);
			cella.disableBorderSide(4);
			cella.disableBorderSide(8);
			cella.setPaddingTop(30);
			cella.setPaddingBottom(5);
			tabella.addCell(cella);
			document.add(tabella);

			// sottotitolo
			paragrafo = new Paragraph("\n\nTABULATO RIEPILOGATIVO DELLE MULTE", smallFont);
			paragrafo.setAlignment(Element.ALIGN_CENTER);
			aggiungiLineaVuota(paragrafo, 2);
			document.add(paragrafo);
			// info multa
			tabella = new PdfPTable(2);
			tabella.setWidthPercentage(100);

			cella = new PdfPCell(new Phrase("CODICE MULTA: " + anagraficaMulte[i]));
			cella.setHorizontalAlignment(Element.ALIGN_LEFT);
			cella.setBorder(0);
			tabella.addCell(cella);

			cella = new PdfPCell();
			cella.setBorder(0);
			tabella.addCell(cella);

			cella = new PdfPCell(new Phrase("DESCRIZIONE: " + anagraficaMulte[i + 1]));
			cella.setHorizontalAlignment(Element.ALIGN_LEFT);
			cella.setBorder(0);
			tabella.addCell(cella);

			cella = new PdfPCell(new Phrase("IMPORTO: " + anagraficaMulte[i + 2] + "€"));
			cella.setHorizontalAlignment(Element.ALIGN_RIGHT);
			cella.setBorder(0);
			cella.setPaddingBottom(40);
			tabella.addCell(cella);

			document.add(tabella);

			// tabella
			boolean trovato = false;
			tabella = new PdfPTable(4);
			for (int j = 0; j < multe.length; j += 3) {
				if (multe[j].equals(anagraficaMulte[i])) {
					cella = new PdfPCell(new Phrase("COGNOME", fTabella));
					cella.setHorizontalAlignment(Element.ALIGN_CENTER);
					cella.setGrayFill(0.8f);
					tabella.addCell(cella);

					cella = new PdfPCell(new Phrase("NOME", fTabella));
					cella.setHorizontalAlignment(Element.ALIGN_CENTER);
					cella.setGrayFill(0.8f);
					tabella.addCell(cella);

					cella = new PdfPCell(new Phrase("DATA", fTabella));
					cella.setHorizontalAlignment(Element.ALIGN_CENTER);
					cella.setGrayFill(0.8f);
					tabella.addCell(cella);

					cella = new PdfPCell(new Phrase("TARGA", fTabella));
					cella.setHorizontalAlignment(Element.ALIGN_CENTER);
					cella.setGrayFill(0.8f);
					tabella.addCell(cella);

					trovato = true;
					j = multe.length;
				}
			}
			if (!trovato) {
				paragrafo = new Paragraph("NESSUNA MULTA PRESENTE PER QUESTO CODICE");
				paragrafo.setAlignment(Element.ALIGN_CENTER);
				document.add(paragrafo);
			}

			for (int j = 0; j < multe.length; j += 3) {
				if (multe[j].equals(anagraficaMulte[i])) {
					for (int k = 0; k < targhe.length; k += 5) {
						if (targhe[k].equals(multe[j + 1])) {
							cella = new PdfPCell(new Phrase(targhe[k + 1], testo));
							tabella.addCell(cella);
							cella = new PdfPCell(new Phrase(targhe[k + 2], testo));
							tabella.addCell(cella);
							cella = new PdfPCell(new Phrase(multe[j + 1], testo));
							tabella.addCell(cella);
							cella = new PdfPCell(new Phrase(multe[j + 2], testo));
							tabella.addCell(cella);
							contaRighe++;
							if (contaRighe > 0 & contaRighe % 15 == 0) {
								document.add(tabella);
								tabella.flushContent();
								cb = writer.getDirectContent();
								Phrase nPag = new Phrase("N° pag " + contaPagine, testo);
								contaPagine++;
								ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, nPag, document.right(),
										document.bottom(), 0);
								document.newPage();
							}
						}
					}
				}
			}
			if (trovato) {
				cella = new PdfPCell();
				cella.disableBorderSide(8);
				tabella.addCell(cella);

				cella = new PdfPCell();
				cella.disableBorderSide(4);
				cella.disableBorderSide(8);
				tabella.addCell(cella);

				cella = new PdfPCell();
				cella.disableBorderSide(4);
				cella.disableBorderSide(8);
				tabella.addCell(cella);

				cella = new PdfPCell(new Phrase("Totale: " + (importo * contaRighe) + "€", testo));
				cella.disableBorderSide(4);
				tabella.addCell(cella);
				document.add(tabella);
			}

			cb = writer.getDirectContent();
			Phrase nPag = new Phrase("N° pag " + contaPagine, testo);
			ColumnText.showTextAligned(cb, Element.ALIGN_CENTER, nPag, document.right(), document.bottom(), 0);
		}

	}

	private static void aggiungiLineaVuota(Paragraph paragraph, int number) {
		// TODO Auto-generated method stub
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph(" "));
		}
	}

	private static ArrayList<String> Confronta(String[] multe, String[] anagraficaMulte, String[] targhe) {
		ArrayList<String> recordConfrontatiCorretti = new ArrayList<>();

		// confronto solo i codici tra multe e anagraficaMulte
		for (int i = 0; i < multe.length; i += 3) {
			boolean trovato = false;
			for (int j = 0; j < anagraficaMulte.length; j += 3) {
				if (multe[i].equals(anagraficaMulte[j])) {
					j = anagraficaMulte.length;
					trovato = true;
				}
			}
			// se il codice è uguale allora confronto la targa con multe come join
			// se anche qui le targhe sono giuste lo aggiungo all'arraylist finale
			if (trovato) {
				for (int j = 0; j < targhe.length; j += 5) {
					if (multe[i + 1].equals(targhe[j])) {
						recordConfrontatiCorretti.add(multe[i]);
						recordConfrontatiCorretti.add(targhe[j]);
					}
				}
				while (i < multe.length - 3 && multe[i].equals(multe[i + 3])) {
					i += 3;
				}
			} else {
				System.out.println(multe[i] + " non corretto");
			}
		}
		// System.out.println("recordConfrontatiCorretti " + recordConfrontatiCorretti);
		return recordConfrontatiCorretti;

	}

	private static String[] Read(String path) {
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

		// System.out.println(Arrays.toString(file));
		return file;
	}
}

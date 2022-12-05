package Lezione11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Es11 {
	private static String serverName = "10.153.120.35";
	private static String portNumber = "3308";
	private static String sid = "corsodb004";
	private static String userName = "corsodb004";
	private static String password = "ciaociao";

	private static Document document = new Document();
	private static Connessione oggcon;
	private static Connection con;

	static ArrayList<Movimenti> movimenti;
	static ArrayList<ContiCorrenti> contiCorrenti;

	public static void main(String[] args) throws DocumentException {
		try {
			oggcon = new Connessione(serverName, portNumber, sid, userName, password);
			con = oggcon.connetti();
			con.setAutoCommit(false);

			Movimenti.Read(con);
			ContiCorrenti.Read(con);

			creaTabella();

			con.close();
			document.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void creaTabella() throws FileNotFoundException, DocumentException, SQLException {

		PdfWriter writer = PdfWriter.getInstance(document,
				new FileOutputStream("src/Lezione11/Es11.pdf"));
		
		document.open();
		Paragraph paragrafo;
		PdfPTable tabella;
		PdfPCell cella;

		String query = "SELECT * FROM ContiCorrenti";
		Statement st;

		st = con.createStatement();
		ResultSet risultato = st.executeQuery(query);
		
		
		while(risultato.next()) {
			
			Double saldo = Double.parseDouble(risultato.getString(3));
			paragrafo = new Paragraph("TABULATO RIEPILOGATIVO CORRENTISTI");
			paragrafo.setAlignment(Element.ALIGN_CENTER);
			aggiungiLineaVuota(paragrafo, 2);
			document.add(paragrafo);
			
			paragrafo = new Paragraph("Codice conto corrente: " + risultato.getString(1));
			document.add(paragrafo);
			
			query			= "SELECT Cognome, Nome FROM Anagrafica WHERE Cod_Anag = " + risultato.getString(2);
			st				= con.createStatement();
			ResultSet dati 	= st.executeQuery(query);
			
			dati.next();
			paragrafo = new Paragraph("Intestatario: " + dati.getString(1) + ", " + dati.getString(2));
			aggiungiLineaVuota(paragrafo, 1);
			document.add(paragrafo);
			
			tabella = new PdfPTable(4);
			cella = new PdfPCell(new Phrase("Data movimento"));
			tabella.addCell(cella);
			cella = new PdfPCell(new Phrase("Data valuta"));
			tabella.addCell(cella);
			cella = new PdfPCell(new Phrase("Descrizione movimento"));
			tabella.addCell(cella);
			cella = new PdfPCell(new Phrase("Importo movimento"));
			tabella.addCell(cella);
			document.add(tabella);	
			tabella.flushContent();
			
			query 	= "SELECT * "
					+ "FROM Movimenti "
					+ "WHERE cod_CC_Mov = " + risultato.getString(1);
			
			st 		= con.createStatement();
			dati 	= st.executeQuery(query);
			
			
			int counter = 1;
			while(dati.next()) {
				
				cella = new PdfPCell(new Phrase(dati.getString(3)));
				tabella.addCell(cella);
				cella = new PdfPCell(new Phrase(dati.getString(4)));
				tabella.addCell(cella);
				cella = new PdfPCell(new Phrase(dati.getString(6)));
				tabella.addCell(cella);
				String importo = dati.getString(5);
				saldo += Double.parseDouble(importo);
				if(importo.contains("-")) {
					importo = importo.replace("-", "");				
					importo += "-";
				}else {
					importo += "+";
				}
				cella = new PdfPCell(new Phrase(importo));
				tabella.addCell(cella);
				
				counter++;
				document.add(tabella);
				tabella.flushContent();
				
				if(counter>20) {			
					PdfContentByte cb = writer.getDirectContent();
					Phrase nPag = new Phrase("Pag " + writer.getPageNumber());
					document.newPage();

					tabella = new PdfPTable(4);
					cella = new PdfPCell(new Phrase("Data movimento"));
					tabella.addCell(cella);
					cella = new PdfPCell(new Phrase("Data valuta"));
					tabella.addCell(cella);
					cella = new PdfPCell(new Phrase("Descrizione movimento"));
					tabella.addCell(cella);
					cella = new PdfPCell(new Phrase("Importo movimento"));
					tabella.addCell(cella);
					document.add(tabella);	
					tabella.flushContent();
					counter = 1;
				}
			}
			
			paragrafo = new Paragraph();
			aggiungiLineaVuota(paragrafo, 1);
			document.add(paragrafo);
			paragrafo = new Paragraph(new Phrase("Totale saldo conto: " + String.format("%,.2f", saldo) + "€"));
			paragrafo.setAlignment(Element.ALIGN_RIGHT);
			document.add(paragrafo);
			
			PdfContentByte cb = writer.getDirectContent();
			Phrase nPag = new Phrase("Pag " + writer.getPageNumber());
			ColumnText.showTextAligned(cb, Element.ALIGN_RIGHT, nPag, document.right(), document.bottom(), 0);
			document.newPage();
		}

	}

	public static void aggiungiLineaVuota(Paragraph paragrafo, int number) {
			for(int i=0; i<number; i++) {
				paragrafo.add(new Paragraph(" "));
			}
		}

}

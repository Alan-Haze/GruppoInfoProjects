package Lezione12;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Lezione11.Connessione;
import Lezione11.ContiCorrenti;
import Lezione11.Movimenti;

public class Es12 {
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
	private static Font titolo = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, BaseColor.RED);

	public static void main(String[] args) throws DocumentException {
		// TODO Auto-generated method stub
		try {
			oggcon = new Connessione(serverName, portNumber, sid, userName, password);
			con = oggcon.connetti();
			con.setAutoCommit(false);

			Movimenti.Read(con);
			ContiCorrenti.Read(con);

			creat();

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

	private static void creat() throws FileNotFoundException, DocumentException, SQLException {
		// TODO Auto-generated method stub

		PdfWriter.getInstance(document, new FileOutputStream("src/Lezione12/ese12.pdf"));
		document.open();

		Paragraph p;
		PdfPTable t;
		PdfPCell c;

		String query = "SELECT * " + "FROM Anagrafica AS A " + "WHERE A.Cod_anag IN " + "(SELECT CC.cod_anag_saldo "
				+ "FROM ContiCorrenti AS CC " + "WHERE CC.cod_CC IN " + "(SELECT M.Cod_cc_mov " + "FROM Movimenti AS M "
				+ "WHERE ABS(M.importo_operazione) > '20' " + "AND MONTH(data_mov) = '07' "
				+ "AND YEAR(data_mov) = '2019') " + "GROUP BY CC.cod_anag_saldo " + "HAVING count(*) > 1);";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		while (rs.next()) {
			document.newPage();
			p = new Paragraph("Tabulato Conti Correnti Clienti", titolo);
			p.setAlignment(Element.ALIGN_CENTER);
			aggiungiLineaVuota(p, 2);
			document.add(p);

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Calendar cal = Calendar.getInstance();

			// Intestatario
			p = new Paragraph(dateFormat.format(cal.getTime()));
			document.add(p);
			t = new PdfPTable(1);
			// soluzione
			t.setWidthPercentage(20);
			// soluzione
			t.setHorizontalAlignment(Element.ALIGN_RIGHT);

			c = new PdfPCell(new Phrase("INTESTATARIO"));
			c.setUseAscender(true);
			c.setVerticalAlignment(Element.ALIGN_MIDDLE);
			c.setHorizontalAlignment(Element.ALIGN_CENTER);
			c.setGrayFill(0.8f);
			t.addCell(c);
			document.add(t);

			t = new PdfPTable(1);
			t.setWidthPercentage(40);
			t.setHorizontalAlignment(Element.ALIGN_RIGHT);

			c = new PdfPCell(new Phrase("" + rs.getString(2) + " " + rs.getString(3)));
			c.disableBorderSide(2);
			t.addCell(c);

			c = new PdfPCell(new Phrase("" + rs.getString(5)));
			c.disableBorderSide(1 | 2);
			t.addCell(c);

			c = new PdfPCell(new Phrase("" + rs.getString(6)));
			c.disableBorderSide(1);
			t.addCell(c);

			document.add(t);

			query = "SELECT CC.Cod_cc,CC.Importo_saldo, CC.Fido FROM ContiCorrenti AS CC WHERE CC.cod_anag_saldo IN(SELECT A.Cod_anag FROM Anagrafica AS A WHERE A.Cod_anag = '"
					+ rs.getString(1) + "');";

			st = con.createStatement();
			ResultSet rs1 = st.executeQuery(query);

			// DATI conto
			while (rs1.next()) {
				t = new PdfPTable(1);
				t.setWidthPercentage(20);
				t.setHorizontalAlignment(Element.ALIGN_LEFT);

				c = new PdfPCell(new Phrase("DATI CONTO"));
				c.setUseAscender(true);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setGrayFill(0.8f);
				t.addCell(c);
				document.add(t);

				t = new PdfPTable(1);
				t.setWidthPercentage(40);
				t.setHorizontalAlignment(Element.ALIGN_LEFT);

				c = new PdfPCell(new Phrase("Conto: " + rs1.getString(1)));
				t.addCell(c);
				document.add(t);

				t = new PdfPTable(1);
				t.setWidthPercentage(25);
				t.setHorizontalAlignment(Element.ALIGN_RIGHT);

				c = new PdfPCell(new Phrase("LISTA MOVIMENTI"));
				c.setUseAscender(true);
				c.setVerticalAlignment(Element.ALIGN_MIDDLE);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				c.setGrayFill(0.8f);
				t.addCell(c);
				// SOLUZIONE
				document.add(t);
				// SOLUZIONE
				t = new PdfPTable(3);
				t.setWidthPercentage(100);

				// prima riga
				c = new PdfPCell();
				c.disableBorderSide(2 | 8);
				t.addCell(c);

				c = new PdfPCell();
				c.disableBorderSide(2 | 4 | 8);
				t.addCell(c);

				c = new PdfPCell(new Phrase("Saldo contabile:      " + rs1.getString(2)));
				c.disableBorderSide(2 | 4);
				t.addCell(c);

				// seconda riga
				c = new PdfPCell();
				c.disableBorderSide(1 | 2 | 8);
				t.addCell(c);

				c = new PdfPCell();
				c.setBorder(0);
				t.addCell(c);

				c = new PdfPCell(new Phrase("Fido:                        " + rs1.getString(3)));
				c.disableBorderSide(1 | 2 | 4);
				t.addCell(c);

				// terza riga
				c = new PdfPCell();
				c.disableBorderSide(1 | 2 | 8);
				t.addCell(c);

				c = new PdfPCell();
				c.setBorder(0);
				t.addCell(c);

				c = new PdfPCell(new Phrase("Saldo disponibile: " + String.format("%.2f",
						(Double.parseDouble(rs1.getString(2)) + Double.parseDouble(rs1.getString(3))))));
				c.disableBorderSide(1 | 2 | 4);
				t.addCell(c);

				// quarta riga
				query = "SELECT count(*) " + "FROM Movimenti AS M " + "WHERE M.cod_CC_mov IN " + "(SELECT CC.cod_cc "
						+ "FROM ContiCorrenti AS CC " + "INNER JOIN Anagrafica AS A ON CC.cod_anag_saldo = A.Cod_anag "
						+ "WHERE A.Cod_anag = '" + rs.getString(1) + "' " + "AND M.importo_operazione < -20 "
						+ "AND MONTH(data_mov) = 07 " + "AND YEAR(data_mov) = 2019 " + "AND M.cod_CC_mov = "
						+ rs1.getString(1) + ");";
				st = con.createStatement();
				ResultSet cont = st.executeQuery(query);
				cont.next();

				c = new PdfPCell(new Phrase("N° movimenti mese di Luglio: " + cont.getString(1)));
				c.disableBorderSide(1 | 2 | 8);
				t.addCell(c);

				c = new PdfPCell();
				c.setBorder(0);
				t.addCell(c);

				c = new PdfPCell();
				c.disableBorderSide(1 | 2 | 4);
				t.addCell(c);

				// quinta riga
				c = new PdfPCell();
				c.disableBorderSide(1 | 2 | 8);
				t.addCell(c);

				c = new PdfPCell();
				c.setBorder(0);
				t.addCell(c);

				c = new PdfPCell();
				c.disableBorderSide(1 | 2 | 4);
				t.addCell(c);

				// sesta riga
				c = new PdfPCell(new Phrase("Importo movimento"));
				c.disableBorderSide(1 | 2 | 8);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				t.addCell(c);

				c = new PdfPCell(new Phrase("Descrizione movimento"));
				c.setBorder(0);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				t.addCell(c);

				c = new PdfPCell(new Phrase("Data movimento"));
				c.disableBorderSide(1 | 2 | 4);
				c.setHorizontalAlignment(Element.ALIGN_CENTER);
				t.addCell(c);

				// settima riga (+)
				query = "SELECT M.data_mov, M.descr_mov, M.importo_operazione " + "FROM Movimenti AS M "
						+ "WHERE M.cod_CC_mov IN" + "(SELECT CC.cod_cc " + "FROM ContiCorrenti AS CC "
						+ "INNER JOIN Anagrafica AS A ON CC.cod_anag_saldo = A.Cod_anag " + "WHERE A.Cod_anag = '"
						+ rs.getString(1) + "' " + "AND M.importo_operazione < -20 " + "AND MONTH(data_mov) = 07 "
						+ "AND YEAR(data_mov) = 2019 " + "AND M.cod_CC_mov = " + rs1.getString(1) + ");";
				st = con.createStatement();
				ResultSet mov = st.executeQuery(query);
				while (mov.next()) {
					c = new PdfPCell(new Phrase("" + mov.getString(1)));
					c.disableBorderSide(1 | 2 | 8);
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					t.addCell(c);

					c = new PdfPCell(new Phrase("" + mov.getString(2)));
					c.setBorder(0);
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					t.addCell(c);

					c = new PdfPCell(new Phrase("" + mov.getString(3)));
					c.disableBorderSide(1 | 2 | 4);
					c.setHorizontalAlignment(Element.ALIGN_CENTER);
					t.addCell(c);
				}

				// chiusura t
				c = new PdfPCell(new Phrase(" "));
				c.disableBorderSide(1 | 8);
				t.addCell(c);

				c = new PdfPCell();
				c.disableBorderSide(1 | 4 | 8);
				t.addCell(c);

				c = new PdfPCell();
				c.disableBorderSide(1 | 4);
				t.addCell(c);
				document.add(t);

				p = new Paragraph(" ");
				aggiungiLineaVuota(p, 1);
				document.add(p);
			}
		}

	}

	public static void aggiungiLineaVuota(Paragraph paragrafo, int number) {
		for (int i = 0; i < number; i++) {
			paragrafo.add(new Paragraph(" "));
		}
	}

}

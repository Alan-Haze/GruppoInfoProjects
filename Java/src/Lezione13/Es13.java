package Lezione13;

import java.io.*;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Lezione11.Connessione;
import jxl.CellView;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class Es13 {
	private static String serverName = "10.153.120.35";
	private static String portNumber = "3308";
	private static String sid = "corsodb004";
	private static String userName = "corsodb004";
	private static String password = "ciaociao";
	private static Connessione oggcon;
	private static Connection con;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {

			oggcon = new Connessione(serverName, portNumber, sid, userName, password);
			Connection con = oggcon.connetti();
			String query = "SELECT CC.cod_cc, A.cognome, A.nome, A.rag_soc, A.sesso, A.partita_iva, SUM(M.importo_operazione) AS TOT_MOVIMENTI "
					+ "FROM Anagrafica AS A " + "INNER JOIN ContiCorrenti AS CC ON A.cod_anag = CC.cod_anag_saldo "
					+ "INNER JOIN Movimenti AS M ON CC.cod_cc = M.cod_cc_mov " + "WHERE M.cod_cc_mov IN "
					+ "(SELECT M.cod_cc_mov " + "FROM Movimenti AS M " + "GROUP BY M.cod_cc_mov "
					+ "HAVING SUM(M.importo_operazione) > 1000) " + "GROUP BY M.cod_cc_mov "
					+ "ORDER BY TOT_MOVIMENTI DESC;";
			Statement st = con.createStatement();
			ResultSet dati = st.executeQuery(query);

			creaExcel(dati);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void creaExcel(ResultSet dati) {

		try {
			WritableWorkbook workbook = Workbook.createWorkbook(new File("src/Lezione13/DonneUomini1.xls"));

			WritableSheet uomini = workbook.createSheet("uomini", 0);
			WritableSheet donne = workbook.createSheet("donne", 1);

			ResultSetMetaData rsmd = dati.getMetaData();
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				createCell(uomini, Border.ALL, uomini.getColumns(),
						new Label(uomini.getColumns(), 0, rsmd.getColumnName(i).replace("_", " ").toUpperCase()),
						Colour.OCEAN_BLUE);
				createCell(donne, Border.ALL, donne.getColumns(),
						new Label(donne.getColumns(), 0, rsmd.getColumnName(i).replace("_", " ").toUpperCase()),
						Colour.PINK2);
			}

			double sommaM = 0;
			double sommaF = 0;
			while (dati.next()) {
				int rigaM = uomini.getRows();
				int rigaF = donne.getRows();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					if (dati.getString(5).equals("M")) {
						uomini.addCell(new Label(i - 1, rigaM, dati.getString(i)));
					} else {
						donne.addCell(new Label(i - 1, rigaF, dati.getString(i)));
					}
				}
				if (dati.getString(5).equals("M")) {
					sommaM += Double.parseDouble(dati.getString(7));
				} else {
					sommaF += Double.parseDouble(dati.getString(7));
				}
				rigaM++;
				rigaF++;
			}

			createCell(uomini, Border.ALL, uomini.getColumns(),
					new Label(uomini.getColumns() - 2, uomini.getRows(), "TOTALE"), Colour.OCEAN_BLUE);
			createCell(uomini, Border.ALL, uomini.getColumns(),
					new Label(uomini.getColumns() - 1, uomini.getRows() - 1, String.format("%.2f", sommaM)),
					Colour.OCEAN_BLUE);

			createCell(donne, Border.ALL, donne.getColumns(),
					new Label(donne.getColumns() - 2, donne.getRows(), "TOTALE"), Colour.PINK2);
			createCell(donne, Border.ALL, donne.getColumns(),
					new Label(donne.getColumns() - 1, donne.getRows() - 1, String.format("%.2f", sommaF)),
					Colour.PINK2);

			workbook.write();
			workbook.close();
			System.out.println("file excel creato, aprire con tasto destro sul file e SystemEditor");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void createCell(WritableSheet sheet, Border border, int indice, Label label, Colour color)
			throws WriteException {
		WritableFont fontCaratteri = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
		WritableCellFormat cf = new WritableCellFormat(fontCaratteri);
		cf.setBorder(border, BorderLineStyle.THIN);
		cf.setVerticalAlignment(VerticalAlignment.CENTRE);
		cf.setAlignment(Alignment.CENTRE);
		cf.setBackground(color);
		cf.setLocked(false);
//		CellView dimCella = new CellView();
//		dimCella.setAutosize(true);
		label.setCellFormat(cf);
		sheet.setColumnView(indice, 25); 
		sheet.setRowView(0, 400); 
		sheet.addCell(label);
	}

}

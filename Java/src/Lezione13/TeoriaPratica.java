package Lezione13;

import java.io.*;
import java.util.Calendar;

import jxl.*;
import jxl.write.*;
import jxl.write.Boolean;
import jxl.write.Number;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.CellView;
import jxl.format.Alignment;

public class TeoriaPratica {
	
	public void fileExcel() throws WriteException{
		System.out.println("Creazione del documento Excel...");
		WritableWorkbook workbook;
		try {
			//dichiarazione del percorso del file .xls e creazione dell'oggetto
			workbook = Workbook.createWorkbook(new File("out/ExcelOut.xls"));
			
			//dichiarazione del nome dello sheet
			WritableSheet sheet = workbook.createSheet("foglio1", 0);
			
			/* Intestazione della tabella
			 * creazione delle label dell'intestazione @param: int colonna, int riga, String testo */
			
			/* Chiamata del metodo con i settaggi di formazione per i Titoli colonne */
			cellFormatta(sheet, Border.ALL, BorderLineStyle.MEDIUM, 0, new Label(0, 0, "Float		1"), Colour.GRAY_50);
			cellFormatta(sheet, Border.ALL, BorderLineStyle.MEDIUM, 1, new Label(1, 0, "Numeri		2"), Colour.GRAY_50);
			cellFormatta(sheet, Border.ALL, BorderLineStyle.MEDIUM, 2, new Label(2, 0, "Date/Dati	3"), Colour.GRAY_50);
			
			/* Corpo della tabella */
			
			/* Caricamento della PRIMA colonna FLOAT */
			WritableCellFormat formatoFloat = new WritableCellFormat(NumberFormats.FLOAT);
			formatoFloat.setBorder(Border.ALL, BorderLineStyle.DASH_DOT);	//definizione del bordo delle celle
			formatoFloat.setAlignment(Alignment.RIGHT); 					//allineamento a destra del contenuto delle celle
			double dato = 3.1459;
			sheet.addCell(new Number(0, 1, dato, 	formatoFloat));
			sheet.addCell(new Number(0, 2, 2, 		formatoFloat));
			sheet.addCell(new Number(0, 3, 3.085, 	formatoFloat));
			sheet.addCell(new Number(0, 4, 34.01, 	formatoFloat));
			
			/* Caricamento della SECONDA colonna Numeri */
			sheet.addCell(new Number(1, 1, 1234.56));
			sheet.addCell(new Number(1, 2, -9.87654));
			
			WritableCellFormat integerFormat = new WritableCellFormat(NumberFormats.INTEGER);
			sheet.addCell(new Number(1, 3, 3.141519, integerFormat));
			
			WritableCellFormat fivedpsFormat = new WritableCellFormat(new NumberFormat("#.#####"));
			sheet.addCell(new Number(1, 4, 3.141519, fivedpsFormat));
			
			/* Caricamento della TERZA colonna Numeri */
			WritableCellFormat dateFormat = new WritableCellFormat(new DateFormat("dd MM yyyy hh:mm:ss"));
			dateFormat.setBorder(Border.ALL, BorderLineStyle.MEDIUM, Colour.BLUE);
			dateFormat.setAlignment(Alignment.CENTRE);
			DateTime dateCell = new DateTime(2, 1, Calendar.getInstance().getTime(), dateFormat);
			sheet.addCell(dateCell);
			
			/* Inserimento data formattata in un passaggio */
			sheet.addCell(new DateTime(2, 2, Calendar.getInstance().getTime(), new WritableCellFormat(new DateFormat("dd-mm-yyyy"))));
			
			WritableCellFormat formatoCell = new WritableCellFormat();
			formatoCell.setBorder(Border.ALL, BorderLineStyle.MEDIUM, Colour.BLUE);
			formatoCell.setAlignment(Alignment.CENTRE);
			sheet.addCell(new Label(2, 3, "Inserisco una stringa", formatoCell));
			sheet.addCell(new Boolean(2, 3, true, formatoCell));
			
			/* Scrittura e chiusura dell'oggetto e del file */
			workbook.write();
			workbook.close();
		}catch (WriteException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void cellFormatta(WritableSheet sheet, Border border, BorderLineStyle borderLineStyle, int indice, Label label, Colour color) throws WriteException{
		WritableFont fontCaratteri		= new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD, true);
		WritableCellFormat formatoCell	= new WritableCellFormat(fontCaratteri);
		formatoCell.setBorder(border, borderLineStyle);
		formatoCell.setAlignment(Alignment.CENTRE);
		formatoCell.setBackground(color);
		CellView dimCella				= new CellView();
		dimCella.setAutosize(true);
		label.setCellFormat(formatoCell);
		sheet.setColumnView(indice, dimCella);		//settaggio della dimensione della colonna
		sheet.setRowView(0, 400);					//settaggio della dimensione della riga
		sheet.addCell(label);
	}

	public static void main(String[] args) {
		try {
			TeoriaPratica file = new TeoriaPratica();
			file.fileExcel();
		}catch (WriteException e) {
			System.out.println("Errore durante generazione del file Excel");
			e.printStackTrace();
		}
	}

}

package Lezione7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Libri> str1 = new ArrayList<Libri>();
		ArrayList<Archivio> str2 = new ArrayList<Archivio>();
		String Riga = "";

		try (BufferedReader br1 = new BufferedReader(new FileReader("out/Esercizio 6/libri.txt"));
				BufferedReader br2 = new BufferedReader(new FileReader("out/Esercizio 6/archiviolibri.txt")))
		{   
			File file = new File("src/Lezione7/fileAggiorna.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			if (file.exists()) {
		
				System.out.println("il file esiste già ed è stato aggiornato");
			} else if (file.createNewFile()) {
				System.out.println("il file è stato creato");
			} else {
				System.out.println("file non creato");
			}
			
			while ((Riga = br1.readLine()) != null) {
				// System.out.println("Riga letta: " + Riga);
				String campi[] = Riga.split("-");
				int codice_libro = Integer.parseInt(campi[0]);
				int quantità = Integer.parseInt(campi[1]);
				String prezzo = campi[2];
				String data = campi[3];
				Libri libroriga = new Libri(codice_libro, quantità, prezzo, data);
				str1.add(libroriga);
			}

			while ((Riga = br2.readLine()) != null) {
				// System.out.println("Riga letta: " + Riga);
				String campi[] = Riga.split("-");
				int codice_libro = Integer.parseInt(campi[0]);
				String titolo_libro = campi[1];
				Archivio archivioriga = new Archivio(codice_libro, titolo_libro);
				str2.add(archivioriga);
					
			}
			
			for(Archivio item2 : str2) {
				int prezzoTot = 0;
				for(Libri item1 : str1) {
					if(item2.getCodice_libro() == item1.getCodice_libro()) {
						
						prezzoTot = prezzoTot + (item1.getQuantità()*Integer.parseInt(item1.getPrezzo()) );
					}
				}bw.write(item2.getCodice_libro()+"-"+item2.getTitolo_libro()+"-"+ prezzoTot+ "\n");
			}
			bw.flush();
			bw.close();
			
		
		} catch (FileNotFoundException e) {
			System.out.println("Errore" + e.toString());
		} catch (IOException e) {
			System.out.println("Errore" + e.toString());
		}

	}

}

package Lezione7B;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Lezione7.Archivio;
import Lezione7.Libri;

public class Main {

	public static void main(String[] args) throws ParseException {

		

		ArrayList<Prodotti> str1 = new ArrayList<Prodotti>();
		ArrayList<Ordinazioni> str2 = new ArrayList<Ordinazioni>();

		String Riga;
		try (BufferedReader br1 = new BufferedReader(new FileReader("out/Esercizio 7/prodotti.txt"));
				BufferedReader br2 = new BufferedReader(new FileReader("out/Esercizio 7/ordinazioni.txt"))) {
			while ((Riga = br1.readLine()) != null) {
				// System.out.println("Riga letta: " + Riga);
				String campi[] = Riga.split("-");
				int codice_prodotto = Integer.parseInt(campi[0]);
				String descrizione = campi[1];
				Prodotti prodotto = new Prodotti(codice_prodotto, descrizione);
				str1.add(prodotto);

			}
			while ((Riga = br2.readLine()) != null) {
				// System.out.println("Riga letta: " + Riga);
				String campi[] = Riga.split("-");
				int codice_prodotto = Integer.parseInt(campi[0]);
				int quantità = Integer.parseInt(campi[1]);
				Date data = new SimpleDateFormat("dd/MM/yyyy").parse(campi[2]);
				;
				Ordinazioni ordinazione = new Ordinazioni(codice_prodotto, quantità, data);
				str2.add(ordinazione);

			}
			for (Prodotti item1 : str1) {
				int qTot = 0;
				for (Ordinazioni item2 : str2) {
					if (item1.getCodice_prodotto() == item2.getCodice_prodotto()) {
						qTot = qTot + (item2.getQuantità() );
					}				
				}
				
				if(qTot == 0) {
					ArrayList <Integer> mancanti = new ArrayList<Integer>();
					mancanti.add(item1.getCodice_prodotto());
					for (int i = 0; i < mancanti.size(); i++)				          
			            System.out.print("Questo prodotto manca: "+ mancanti.get(i) + "\n"); 
				}
				
				System.out.println( item1.getCodice_prodotto() +"-"+ item1.getDescrizione() +"-"+ qTot+"\n");
				
				 //CREARE UN NUOVO FILE IN CUI INSERIRE DATI, POI INSERIRLI IN UN ARRAYLIST E 
				//COMPARARE LE QUANTITA.
				
			}

		} catch (FileNotFoundException e) {
			System.out.println("Errore" + e.toString());
		} catch (IOException e) {
			System.out.println("Errore" + e.toString());
		}

	}

}

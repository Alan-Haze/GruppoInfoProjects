package Lezione8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Treno {

	String partenza;
	String arrivo;

	public Treno(String partenza, String arrivo) {

		this.partenza = partenza;
		this.arrivo = arrivo;
	}

	public String verificaDirezione() {
		return (this.partenza + "/" + this.arrivo);

	}

	public static int valid() {
		// creo nuovo oggetto Treno e lo aggiungo ad una lista
		Treno tappa = new Treno("Brianza", "Tronzano");
		ArrayList<Treno> listaTappe = new ArrayList<Treno>();
		listaTappe.add(tappa);

		// Creo la lista di Citta dal file treni.txt
		ArrayList<String> listaCitta = new ArrayList<String>();
		String Riga;
		try (BufferedReader br1 = new BufferedReader(new FileReader("out/Esercizio 8/treni.txt"))) {
			while ((Riga = br1.readLine()) != null) {
				// System.out.println("Riga letta: " + Riga);
				String campi[] = Riga.split("-");
				String città = campi[1];
				String citta = new String(città);
				listaCitta.add(citta);
			}
			for (Treno item1 : listaTappe) {
				for (String item2 : listaCitta) {
					if (listaCitta.contains(item1.getPartenza()) && listaCitta.contains(item1.getArrivo()))
						return 0;
					if (listaCitta.contains(item1.getPartenza()) == false)
						return 1;
					if (listaCitta.contains(item1.getArrivo()) == false)
						return 2;
					if (listaCitta.contains(item1.getPartenza()) == false
							&& listaCitta.contains(item1.getArrivo()) == false)
						return 3;

				}

			}
		} catch (FileNotFoundException e) {
			return 4;
		} catch (IOException e) {
			return 5;
		}
		return -1;
	}

	private static int indexCitta(String c) {
		c = "Brianza";
		ArrayList<String> listaCitta = new ArrayList<String>();

		String Riga;
		try (BufferedReader br1 = new BufferedReader(new FileReader("out/Esercizio 8/treni.txt"))) {
			while ((Riga = br1.readLine()) != null) {
				// System.out.println("Riga letta: " + Riga);
				String campi[] = Riga.split("-");
				String città = campi[1];
				String citta = new String(città);
				listaCitta.add(citta);
			}
			for (String item : listaCitta) {
				return listaCitta.indexOf(c) + 1;

			}

		} catch (FileNotFoundException e) {
			return 4;
		} catch (IOException e) {
			return 5;
		}
		return -1;
	}

	private static int distanzaKm() {

		ArrayList<Treni> listaTreni = new ArrayList<Treni>();
		String Riga;
		int distanza = 0;
		try (BufferedReader br1 = new BufferedReader(new FileReader("out/Esercizio 8/treni.txt"))) {
			while ((Riga = br1.readLine()) != null) {
				// System.out.println("Riga letta: " + Riga);
				String campi[] = Riga.split("-");
				int km = Integer.parseInt(campi[0]);
				String città = campi[1];
				Treni t = new Treni(km, città);
				listaTreni.add(t);
			}
			Treno tappa = new Treno("Brianza", "Tronzano");
			ArrayList<Treno> listaTappe = new ArrayList<Treno>();
			listaTappe.add(tappa);

			int kmPartenza = 0;
			int kmArrivo = 0;

			for (Treni item2 : listaTreni) {
				if (tappa.getPartenza().equals(item2.getCittà())) {
					kmPartenza = item2.getKm();
					System.out.println("km di partenza: "+kmPartenza);
				}

				if (tappa.getArrivo().equals(item2.getCittà())) {
					kmArrivo = item2.getKm();

					System.out.println("km di arrivo: "+kmArrivo);
				}

			}

			distanza = kmArrivo - kmPartenza;

		} catch (FileNotFoundException e) {
			return 4;
		} catch (IOException e) {
			return 5;
		}

		return distanza;
	}

	private static int kmCitta(String c) {

		ArrayList<Treni> listaTreni = new ArrayList<Treni>();
		String Riga;
		int distanza = 0;
		try (BufferedReader br1 = new BufferedReader(new FileReader("out/Esercizio 8/treni.txt"))) {
			while ((Riga = br1.readLine()) != null) {

				String campi[] = Riga.split("-");
				int km = Integer.parseInt(campi[0]);
				String città = campi[1];
				Treni t = new Treni(km, città);
				listaTreni.add(t);
			}

			for (Treni item : listaTreni) {

				if (c.equals(item.getCittà()))
					return item.getKm();

				// return listaTreni.indexOf(c).get;

				// return listaTreni.get(listaTreni.indexOf("Brianza")).getKm();

			}

		} catch (FileNotFoundException e) {
			return 4;
		} catch (IOException e) {
			return 5;
		}

		return -100;

	}

	public String getPartenza() {
		return partenza;
	}

	public void setPartenza(String partenza) {
		this.partenza = partenza;
	}

	public String getArrivo() {
		return arrivo;
	}

	public void setArrivo(String arrivo) {
		this.arrivo = arrivo;
	}

	public static void main(String[] args) {
		// System.out.println(indexCitta("Brianza"));
		// System.out.println(valid());
		System.out.println(distanzaKm());
		// System.out.println(kmCitta("Brianza"));
	}
}

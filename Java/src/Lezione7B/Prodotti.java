package Lezione7B;

public class Prodotti {
	int codice_prodotto;
	String descrizione;
	
	public Prodotti(int codice_prodotto, String descrizione) {
		this.codice_prodotto = codice_prodotto;
		this.descrizione = descrizione;
	}

	public int getCodice_prodotto() {
		return codice_prodotto;
	}

	public void setCodice_prodotto(int codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
}

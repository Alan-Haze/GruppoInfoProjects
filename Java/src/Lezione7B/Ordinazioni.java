package Lezione7B;

import java.util.Date;

public class Ordinazioni {
	int codice_prodotto;
	int quantit�;
	Date data;
	public Ordinazioni(int codice_prodotto, int quantit�, Date data) {
		this.codice_prodotto = codice_prodotto;
		this.quantit� = quantit�;
		this.data = data;
	}
	public int getCodice_prodotto() {
		return codice_prodotto;
	}
	public void setCodice_prodotto(int codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}

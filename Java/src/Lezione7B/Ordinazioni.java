package Lezione7B;

import java.util.Date;

public class Ordinazioni {
	int codice_prodotto;
	int quantità;
	Date data;
	public Ordinazioni(int codice_prodotto, int quantità, Date data) {
		this.codice_prodotto = codice_prodotto;
		this.quantità = quantità;
		this.data = data;
	}
	public int getCodice_prodotto() {
		return codice_prodotto;
	}
	public void setCodice_prodotto(int codice_prodotto) {
		this.codice_prodotto = codice_prodotto;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}

package Lezione7;

public class Libri {
	int codice_libro;
	int quantit�;
	String prezzo;
	String data;
	public Libri(int codice_libro, int quantit�, String prezzo, String data) {
		this.codice_libro = codice_libro;
		this.quantit� = quantit�;
		this.prezzo = prezzo;
		this.data = data;
	}
	
	public void stampaPersona() {
		System.out.println(codice_libro + quantit� + prezzo + data);
	}

	public int getCodice_libro() {
		return codice_libro;
	}

	public void setCodice_libro(int codice_libro) {
		this.codice_libro = codice_libro;
	}

	public int getQuantit�() {
		return quantit�;
	}

	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	
}

package Lezione7;

public class Libri {
	int codice_libro;
	int quantità;
	String prezzo;
	String data;
	public Libri(int codice_libro, int quantità, String prezzo, String data) {
		this.codice_libro = codice_libro;
		this.quantità = quantità;
		this.prezzo = prezzo;
		this.data = data;
	}
	
	public void stampaPersona() {
		System.out.println(codice_libro + quantità + prezzo + data);
	}

	public int getCodice_libro() {
		return codice_libro;
	}

	public void setCodice_libro(int codice_libro) {
		this.codice_libro = codice_libro;
	}

	public int getQuantità() {
		return quantità;
	}

	public void setQuantità(int quantità) {
		this.quantità = quantità;
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

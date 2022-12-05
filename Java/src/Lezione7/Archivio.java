package Lezione7;

public class Archivio {
	int codice_libro;
	String titolo_libro;
	
	public Archivio(int codice_libro, String titolo_libro) {
		this.codice_libro = codice_libro;
		this.titolo_libro = titolo_libro;
	}

	public int getCodice_libro() {
		return codice_libro;
	}

	public void setCodice_libro(int codice_libro) {
		this.codice_libro = codice_libro;
	}

	public String getTitolo_libro() {
		return titolo_libro;
	}

	public void setTitolo_libro(String titolo_libro) {
		this.titolo_libro = titolo_libro;
	}
	
}

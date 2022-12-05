package Bean;



import java.sql.Array;
import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class FormInserisci extends ActionForm{
	private String cognome;
	private String nome;
	private String telefono1;
	private String rag_soc;
	private String sesso;
	private String telefono2;
	private String indirizzo;
	private String citta;
	private String data_nascita;
	private String luogo_nascita;
	private String num_cc;
	private String codice_fiscale;
	private String p_iva;
	private String email;
	
	private ArrayList<String> elencoCitta;
	private String errore = "";

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getRag_soc() {
		return rag_soc;
	}

	public void setRag_soc(String rag_soc) {
		this.rag_soc = rag_soc;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getData_nascita() {
		return data_nascita;
	}

	public void setData_nascita(String data_nascita) {
		this.data_nascita = data_nascita;
	}

	public String getLuogo_nascita() {
		return luogo_nascita;
	}

	public void setLuogo_nascita(String luogo_nascita) {
		this.luogo_nascita = luogo_nascita;
	}

	public String getNum_cc() {
		return num_cc;
	}

	public void setNum_cc(String num_cc) {
		this.num_cc = num_cc;
	}

	

	public String getCodice_fiscale() {
		return codice_fiscale;
	}

	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}

	public String getP_iva() {
		return p_iva;
	}

	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<String> getElencoCitta() {
		return elencoCitta;
	}

	public void setElencoCitta(ArrayList<String> elencoCitta) {
		this.elencoCitta = elencoCitta;
	}
	
	public String getErrore() {
		return errore;
	}

	public void setErrore(String errore) {
		this.errore = errore;
	}
}

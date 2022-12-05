package Bean;

import org.apache.struts.action.ActionForm;

public class Persona extends ActionForm{
	@Override
	public String toString() {
		return "Persona [cod_anag=" + cod_anag + ", cognome=" + cognome + ", nome=" + nome + ", rag_soc=" + rag_soc
				+ ", indirizzo=" + indirizzo + ", id_comune=" + id_comune + ", sesso=" + sesso + ", data_nascita="
				+ data_nascita + ", luogo_nascita=" + luogo_nascita + ", cod_fiscale=" + cod_fiscale + ", partita_iva="
				+ partita_iva + ", telefono1=" + telefono1 + ", telefono2=" + telefono2 + ", email=" + email
				+ ", num_cc=" + num_cc + ", citta=" + citta + "]";
	}
	
	private String 	cognome;
	private String	nome;
	private int 	cod_anag;
	private String	rag_soc;
	private String	indirizzo;
	private String	id_comune;
	private String	sesso;
	private String 	data_nascita;
	private String	luogo_nascita;
	private String	cod_fiscale;
	private String	partita_iva;
	private String	telefono1;
	private String	telefono2;
	private String	email;
	
	private String num_cc;
	private String citta;
	
	public int getCod_anag() {
		return cod_anag;
	}
	public void setCod_anag(int cod_anag) {
		this.cod_anag = cod_anag;
	}
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
	public String getRag_soc() {
		return rag_soc;
	}
	public void setRag_soc(String rag_soc) {
		this.rag_soc = rag_soc;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getId_comune() {
		return id_comune;
	}
	public void setId_comune(String id_comune) {
		this.id_comune = id_comune;
	}
	public String getSesso() {
		return sesso;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
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
	public String getCod_fiscale() {
		return cod_fiscale;
	}
	public void setCod_fiscale(String cod_fiscale) {
		this.cod_fiscale = cod_fiscale;
	}
	public String getPartita_iva() {
		return partita_iva;
	}
	public void setPartita_iva(String partita_iva) {
		this.partita_iva = partita_iva;
	}
	public String getTelefono1() {
		return telefono1;
	}
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	public String getTelefono2() {
		return telefono2;
	}
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNum_cc() {
		return num_cc;
	}
	public void setNum_cc(String num_cc) {
		this.num_cc = num_cc;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
}
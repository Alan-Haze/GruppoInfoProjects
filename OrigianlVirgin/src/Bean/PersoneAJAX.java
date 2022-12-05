package Bean;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class PersoneAJAX  extends ActionForm {
	private int idsel;
	private List<PersonaAJAX> elencoNominativi;
	private List<String> elencoCognome;
	private List<String> elencoNome;
	private String stCognome;
	private String stNome;
	private String stNumCC;
	
	
	public String getStNumCC() {
		return stNumCC;
	}
	public void setStNumCC(String stNumCC) {
		this.stNumCC = stNumCC;
	}
	public String getStCognome() {
		return stCognome;
	}
	public void setStCognome(String stCognome) {
		this.stCognome = stCognome;
	}
	public List<PersonaAJAX> getElencoNominativi() {
		return elencoNominativi;
	}
	public void setElencoNominativi(List<PersonaAJAX> elencoNominativi) {
		this.elencoNominativi = elencoNominativi;
	}
	public String getStNome() {
		return stNome;
	}
	public void setStNome(String stNome) {
		this.stNome = stNome;
	}
	public List<String> getElencoCognome() {
		return elencoCognome;
	}
	public void setElencoCognome(List<String> elencoCognome) {
		this.elencoCognome = elencoCognome;
	}
	public List<String> getElencoNome() {
		return elencoNome;
	}
	public void setElencoNome(List<String> elencoNome) {
		this.elencoNome = elencoNome;
	}
	public int getIdsel() {
		return idsel;
	}
	public void setIdsel(int idsel) {
		this.idsel = idsel;
	}
	@Override
	public String toString() {
		return "PersoneAJAX [idsel=" + idsel + ", elencoNominativi=" + elencoNominativi + ", elencoCognome="
				+ elencoCognome + ", elencoNome=" + elencoNome + ", stCognome=" + stCognome + ", stNome=" + stNome
				+ "]";
	}
	
}

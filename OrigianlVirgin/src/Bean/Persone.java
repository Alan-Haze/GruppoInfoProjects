package Bean;

import java.util.List;

import org.apache.struts.action.ActionForm;

public class Persone extends ActionForm{

	@Override
	public String toString() {
		return "Persone [elencoPersone=" + elencoPersone + ", idsel=" + idsel + "]";
	}
	private List<Persona> elencoPersone;
	private int idsel;
	
	public List<Persona> getElencoPersone() {
		return elencoPersone;
	}
	public void setElencoPersone(List<Persona> elencoPersone) {
		this.elencoPersone = elencoPersone;
	}
	public int getIdsel() {
		return idsel;
	}
	public void setIdsel(int idsel) {
		this.idsel = idsel;
	}
}
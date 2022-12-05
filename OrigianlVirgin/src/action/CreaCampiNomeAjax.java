package action;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.Persona;
import Bean.PersonaAJAX;
import Bean.PersoneAJAX;

public class CreaCampiNomeAjax extends Action {
	
	List list = new ArrayList<>();
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("SIAMO DENTRO AJAX");
		PersoneAJAX persone = (PersoneAJAX) form;
		response.setContentType("text/xml");
		String stCognome = request.getParameter("selcognome");
		// stCognome ="Liuasd";
		System.out.println("cognome selezionato: " + stCognome);
		persone.setStCognome(stCognome);
		List<String> nomi = new ArrayList<>();
		for (PersonaAJAX persona : persone.getElencoNominativi()) {
			System.out.println("elenco cognome:" + persona.getCognome());
			if (persona.getCognome().equals(stCognome)) {
				nomi.add(persona.getNome());
			}
		}
		persone.setElencoNome(nomi);
		System.out.println(persone.toString());
		System.out.println("nome caricati" + nomi.toString());
		PrintWriter out = response.getWriter();
		// elimino le parentesi
		out.println(nomi.toString().replace("[", "").replace("]", ""));
		out.close();
		// il return non verra mai chiamato
		
		System.out.println(persone.toString());
		return mapping.findForward("success");
	}

	

}
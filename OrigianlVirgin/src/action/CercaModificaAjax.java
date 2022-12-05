package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Bean.PersoneAJAX;


public class CercaModificaAjax extends org.apache.struts.actions.DispatchAction {
	
	
	public ActionForward metodoCognome(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		PersoneAJAX persone = (PersoneAJAX) form;
		System.out.println("action.CreaCampiModificaAjax.metodoCognome");
		persone.setIdsel(0);
		String nome = request.getParameter("stNome");
		String cognome = request.getParameter("stCognome");
		System.out.println("il cognome del documento è: " + cognome);
		System.out.println("il nome del documento è: " + nome);
		persone.setStNome(nome);
		persone.setStCognome(cognome);
		return mapping.findForward("success");
	}

	public ActionForward metodoCC(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		System.out.println("action.CreaCampiModificaAjax.metodoCC");
		
		PersoneAJAX persone = (PersoneAJAX) form;
		persone.setStNome("");
		persone.setStCognome("");
		String c = request.getParameter("contocc");
		int contocc = Integer.parseInt(c);
		persone.setIdsel(contocc);
		System.out.println("l'idsel da confrontare è: " + persone.getIdsel());
		System.out.println("il contocc del documento è: " + contocc);
		
		return mapping.findForward("success");
	}
}

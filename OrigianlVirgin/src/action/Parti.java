package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

//import bean.BeanMes;

public class Parti extends Action {

@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)throws Exception {
	
	//BeanMes hwForm = (BeanMes) form;
	
	//hwForm.setMessaggio("Benvenuto nel mio Applicativo");
	
	
	System.out.println("parti");
	
	return mapping.findForward("success");
}
}

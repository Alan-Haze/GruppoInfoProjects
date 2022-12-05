package Bean;

import org.apache.struts.action.ActionForm;

public class UserPasswordLogin extends ActionForm {
	private String username;
	private String password ;
	private String errore;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String user) {
		this.username = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getErrore() {
		return errore;
	}
	public void setErrore(String errore) {
		this.errore = errore;
	}
	
}

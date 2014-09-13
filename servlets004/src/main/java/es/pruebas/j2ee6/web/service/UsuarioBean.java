package es.pruebas.j2ee6.web.service;

public class UsuarioBean {	
	private String login;
	private String pass;
		
	public UsuarioBean(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	

	
	
}

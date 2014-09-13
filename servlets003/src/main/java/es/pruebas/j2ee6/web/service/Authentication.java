package es.pruebas.j2ee6.web.service;

import java.io.Serializable;


public class Authentication implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 715201739954686170L;
	
	
	private String login;
	private String rol;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}

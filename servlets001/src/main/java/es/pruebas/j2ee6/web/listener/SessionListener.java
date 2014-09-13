package es.pruebas.j2ee6.web.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("Sesión creada");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("Sesión destruida");	
	}
	
	// ------------------------------------- //
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent ev) {
		System.out.println("Atributo añadido a la sesión" + ev.getValue());
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		System.out.println("Atributo eliminado de la sesión");	
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		System.out.println("Atributo reemplazado de la sesión");	
		
	}
}

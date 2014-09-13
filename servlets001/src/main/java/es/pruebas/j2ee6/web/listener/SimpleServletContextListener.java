package es.pruebas.j2ee6.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SimpleServletContextListener implements ServletContextListener {

	
	@Override
	public void contextInitialized(ServletContextEvent ev) {
		System.out.println("Servlet inicializado. " + ev.getSource()); 
	}
	
	
	@Override
	public void contextDestroyed(ServletContextEvent ev) {
		System.out.println("Servlet destruido. " + ev.getSource());

	}

}

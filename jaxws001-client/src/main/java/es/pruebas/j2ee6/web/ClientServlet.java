package es.pruebas.j2ee6.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import es.pruebas.j2ee6.jax.ws.Entrada;
import es.pruebas.j2ee6.jax.ws.RegistroTelematicoServiceImple;
import es.pruebas.j2ee6.jax.ws.RegistroTelematicoServiceImpleService;



@WebServlet("/")
public class ClientServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8903150649819216880L;


	@Override
	protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1)	throws ServletException, IOException {
		 RegistroTelematicoServiceImpleService serviceClient = new RegistroTelematicoServiceImpleService();
		 RegistroTelematicoServiceImple serviceImpl = serviceClient.getRegistroTelematicoServiceImplePort();
		
		 Entrada entrada = new Entrada();
		 
		 PrintWriter out = arg1.getWriter();
		 out.println("Respuesta" + serviceImpl.registrarEntrada(entrada));
		 out.close();		
	}
}

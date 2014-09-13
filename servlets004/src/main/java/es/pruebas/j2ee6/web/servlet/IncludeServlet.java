package es.pruebas.j2ee6.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.pruebas.j2ee6.web.service.UsuarioBean;

@WebServlet(urlPatterns="/app/include", name="includeServlet")
public class IncludeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1504220962454905746L;
	
	
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		                                         
        ServletContext sc = this.getServletContext();
        
        sc.getRequestDispatcher("/WEB-INF/jsp/parte1.jsp").include(request, response);                
        sc.getRequestDispatcher("/WEB-INF/jsp/parte2.jsp").include(request, response);
	}

}

package es.pruebas.j2ee6.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/app/*", name="miProcessServlet")
public class MiProcessServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1504220962454905746L;
	
	
	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/negocio.jsp").forward(request, response);
	}

}

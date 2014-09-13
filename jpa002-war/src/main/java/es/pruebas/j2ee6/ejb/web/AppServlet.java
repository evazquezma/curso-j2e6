package es.pruebas.j2ee6.ejb.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.pruebas.j2ee6.ejb.persistencia.dao.LogDao;
import es.pruebas.j2ee6.ejb.persistencia.model.LogEntity;

@WebServlet("/")
public class AppServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8263016847232800494L;
	
	@EJB
	private LogDao logDao;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.println("<html lang=\"en\">");
		out.println("<body>");
		out.println("<h1>Usuario con session id: "+request.getSession(true).getId() + "</h1>");
		List<LogEntity> logsEntities = logDao.getAll();
		for (LogEntity logEntity : logsEntities) {
			out.println("<p> "+logEntity+" </p>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
	
	
	
	


}

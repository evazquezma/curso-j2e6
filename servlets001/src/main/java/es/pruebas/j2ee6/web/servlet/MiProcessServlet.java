package es.pruebas.j2ee6.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MiProcessServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1504220962454905746L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out = response.getWriter();
        // Output the results
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>Hola Mundo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Process Servelt</h1>");
        out.println("<h2>Es la petición registrada "+ request.getSession(true).getAttribute("Peticion") + "</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();		
	}

}

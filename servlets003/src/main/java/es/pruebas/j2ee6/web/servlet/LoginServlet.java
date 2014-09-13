package es.pruebas.j2ee6.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.pruebas.j2ee6.web.service.Authentication;

@WebServlet(urlPatterns="/login", name="loginServlet")
public class LoginServlet extends HttpServlet{
	private static final String SESSION_AUTH_KEY = "autenticacion";
	private static final String SESSION_URL_REDIRECT_KEY = "url_redirect";
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1504220962454905746L;
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String login 	= "";	
		if (request.getParameter("login") != null) {
			login = request.getParameter("login");
		}
		
		
		PrintWriter out = response.getWriter();   
        out.println("<html lang=\"es\">");
        out.println("<head>");
        out.println("<title>Hola Mundo</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Login</h1>");                        
        
        out.println("<form method=\"post\">");
        out.println("	<p>Usuario: <input type=\"text\" name=\"login\" size=\"25\" value=\"" + login + "\"></p>");
        out.println("	<p>Nombre: <input type=\"text\" name=\"password\" size=\"25\"></p>");
        out.println("	<br/>");
        out.println("	<input type=\"submit\" value=\"Submit\">" +  "<input type=\"reset\" value=\"Reset\">");
        out.println("</form>");
                
        out.println("</body>");
        out.println("</html>");
        out.close();		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login 	= request.getParameter("login");
		String password = request.getParameter("password");
		
		if ("prueba".equals(login) && "prueba".equals(password)) {
			System.out.println("LoginOK");
			Authentication auth = new Authentication();
			auth.setLogin(login);
			auth.setRol("ROLE_SUPERUSUARIO");
			request.getSession(true).setAttribute(SESSION_AUTH_KEY, auth);
			
			if (request.getSession(true).getAttribute(SESSION_URL_REDIRECT_KEY) != null) {
				response.sendRedirect((String)request.getSession(true).getAttribute(SESSION_URL_REDIRECT_KEY));		
			}
			else {
				response.sendRedirect(request.getContextPath() +  "/app/autenticadoOK");	
			}
		}
		else {
			doGet(request, response);
		}				
	}

}

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

@WebServlet(urlPatterns="/app/forward", name="forwardServlet")
public class ForwardServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 413268290978022246L;
	
	

	@Override	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		                            
        List<UsuarioBean> usuariosBean = new ArrayList<UsuarioBean>();
        usuariosBean.add(new UsuarioBean("admin", "adminPass"));
        usuariosBean.add(new UsuarioBean("super", "superPass"));
        request.setAttribute("usuariosBean", usuariosBean);
        
        request.setAttribute("atributoDeNegocio", "algo"); 
        
        
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/jsp/ejemplo.jsp");
        rd.forward(request, response);
	}

}

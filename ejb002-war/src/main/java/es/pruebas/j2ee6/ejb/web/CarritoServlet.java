package es.pruebas.j2ee6.ejb.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.pruebas.j2ee6.ejb.model.Item;
import es.pruebas.j2ee6.ejb.service.Carrito;

@WebServlet("/")
public class CarritoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8263016847232800494L;
	
	private static final String SESSION_KEY_CARRITO = "carrito";
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		Carrito carrito = recuperarCarritoUsuario(request);
		
		if (request.getParameter("nombre") != null &&
			request.getParameter("cantidad") != null &&
			request.getParameter("precio") != null) {
			
			String nombre = request.getParameter("nombre");
			Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
			Float precio = Float.valueOf(request.getParameter("precio"));
						
			Item item = new Item();
			item.setNombre(nombre);
			item.setPrecio(precio);
			item.setCantidad(cantidad);		  
			carrito.addItem(item);
		}

		pintarContenido(carrito, response.getWriter());		
	}
	
	
	
	
	private void pintarContenido(Carrito carrito, PrintWriter out) {
		out.println("<html lang=\"en\">");
		out.println("<body>");
		out.println("<h1>Hay " + carrito.getItems().size() + " en el carrito de este usuario con un importe total de " + carrito.getTotal() +"</h1>");
		for (Item item : carrito.getItems()) {
			out.println("<p>"+ item + "</p>");
		}
		out.println("</body>");
		out.println("</html>");
		out.close();

	}


	private Carrito recuperarCarritoUsuario(HttpServletRequest request) {
		if (request.getSession(true).getAttribute(SESSION_KEY_CARRITO) != null) {
			return (Carrito) request.getSession(true).getAttribute(SESSION_KEY_CARRITO);
		}
		
		
		try {
			InitialContext ic = new InitialContext();
			Carrito carrito = (Carrito) ic.lookup("java:module/CarritoBean");
			request.getSession(true).setAttribute(SESSION_KEY_CARRITO, carrito);
			return carrito;
		} 
		catch (NamingException e) {
			throw new RuntimeException("Error al recuperar el carrito", e);
		}	
	}

}

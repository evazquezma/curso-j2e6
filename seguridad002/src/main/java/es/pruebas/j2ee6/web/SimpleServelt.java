package es.pruebas.j2ee6.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author evazquezma
 *
 */
@WebServlet(name = "SimpleServelt", urlPatterns = {"/sec/*"})
@ServletSecurity(
		@HttpConstraint(transportGuarantee = TransportGuarantee.NONE,
		rolesAllowed = {"TutorialUser"}))
public class SimpleServelt extends HttpServlet {
    /**
	 *
	 */
	private static final long serialVersionUID = 4093576237736575890L;



	@Override
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<html lang=\"en\">");
        out.println("<head></head>");

        out.println("<body>");
        out.println("<h2>Ejecuntando acción securizada</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }
}

package es.pruebas.j2ee6.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet securizado.
 * Por defecto los roles se dejan con el mismo nombre tanto dentro del servidor como
 * a la hora de emplearlos dentro de la aplicación, lo que evita tener que usar un mapeo
 * en el fichero descriptor (se mapean roles contra grupos)
 *
 * @author evazquezma
 *
 */
@WebServlet(name = "GreetingServlet", urlPatterns = {"/greeting"})
@ServletSecurity(
		@HttpConstraint(transportGuarantee = TransportGuarantee.CONFIDENTIAL,
		rolesAllowed = {"TutorialUser"}))
public class GreetingServlet extends HttpServlet {
    /**
	 *
	 */
	private static final long serialVersionUID = 4093576237736575890L;



	@Override
    protected void doGet(HttpServletRequest request,  HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setBufferSize(8192);
        PrintWriter out = response.getWriter();

        // then write the data of the response
        out.println("<html lang=\"en\">"
                + "<head><title>Hello</title></head>");

        // then write the data of the response
        out.println("<body  bgcolor=\"#ffffff\">"
            + "<img src=\"duke.waving.gif\" alt=\"Duke waving his hand\">"
            + "<form method=\"get\">"
            + "<h2>Hello, my name is Duke. What's yours?</h2>"
            + "<input title=\"My name is: \" type=\"text\" name=\"username\" size=\"25\"/>"
            + "<p></p>"
            + "<input type=\"submit\" value=\"Submit\"/>"
            + "<input type=\"reset\" value=\"Reset\"/>"
            + "</form>");

        String username = request.getParameter("username");
        if (username != null && username.length() > 0) {
            RequestDispatcher dispatcher =  getServletContext().getRequestDispatcher("/response");

            if (dispatcher != null) {
                dispatcher.include(request, response);
            }
        }
        out.println("</body></html>");
        out.close();
    }



    @Override
    public String getServletInfo() {
        return "The Hello servlet says hello to an authenticated user.";
    }
}

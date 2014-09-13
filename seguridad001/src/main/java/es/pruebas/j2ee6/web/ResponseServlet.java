package es.pruebas.j2ee6.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ResponseServlet", urlPatterns={"/response"})
public class ResponseServlet extends HttpServlet {
    /**
	 *
	 */
	private static final long serialVersionUID = -4792735282435265057L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
           PrintWriter out = response.getWriter();

        // then write the data of the response
        String username = request.getParameter("username");
        if (username != null && username.length() > 0) {
            out.println("<h2>Hello, " + username + "!</h2>");
        }
    }




    @Override
    public String getServletInfo() {
        return "The Response servlet says hello.";
    }// </editor-fold>

}

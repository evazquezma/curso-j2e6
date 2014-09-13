package es.pruebas.j2ee6.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns="/contar/*", filterName="simpleFilter")
public class SimpleFilter implements Filter {
	
	private int peticiones = 0;
	
	@Override
	public void destroy() {
		System.out.println("Destroy filtro");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		HttpServletRequest httpRequest  = (HttpServletRequest)request;
		
		System.out.println("Entrando en el filtro con path " + httpRequest.getRequestURI());
		
		httpRequest.getSession(true).setAttribute("Peticion", peticiones++);
				
		chain.doFilter(request, response);
		System.out.println("Saliendo del filtro");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Iniciando filtro " + config.getFilterName());		
	}
	
}

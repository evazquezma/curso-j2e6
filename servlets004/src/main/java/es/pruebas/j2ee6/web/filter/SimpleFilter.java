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




@WebFilter(urlPatterns="/gestionar/*", filterName="simpleFilter")
public class SimpleFilter implements Filter {

		
	
	@Override
	public void destroy() {
		System.out.println("Destroy filtro");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		HttpServletRequest httpRequest  = (HttpServletRequest)request;				
		chain.doFilter(request, response);		
	}

	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Iniciando filtro " + config.getFilterName());		
	}
	
}

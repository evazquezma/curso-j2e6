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
import javax.servlet.http.HttpServletResponse;

import es.pruebas.j2ee6.web.service.Authentication;

@WebFilter(urlPatterns="/gestionar/*", filterName="securityFilter")
public class SecurityFilter implements Filter {
	/**
	 * Nombre del atributo de sesion donde se va a guardar la información de autenticación
	 */
	private static final String SESSION_AUTH_KEY = "autenticacion";
	
	/**
	 * Nombre de atributo de session donde se va a guaradar la url a la que iba el usuario justo antes
	 * de interceptarlo el filtro de seguridad.
	 */
	private static final String SESSION_URL_REDIRECT_KEY = "url_redirect";
	
		
	
	@Override
	public void destroy() {
		System.out.println("Destroy filtro");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {		
		HttpServletRequest httpRequest  = (HttpServletRequest)request;
		
		if (! hayUsuarioAutenticado(httpRequest)) {
			httpRequest.getSession().setAttribute(SESSION_URL_REDIRECT_KEY, httpRequest.getRequestURI());
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
			return;
		}
						
		chain.doFilter(request, response);		
	}

	
	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("Iniciando filtro " + config.getFilterName());		
	}
	
	
	
	
	/**
	 * comprueba si hay autenticación en la sesión
	 * @param request
	 * @return
	 */
	public boolean hayUsuarioAutenticado(HttpServletRequest request) {
		Authentication auth = (Authentication) request.getSession(true).getAttribute(SESSION_AUTH_KEY);
		if (auth != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}

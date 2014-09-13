package es.pruebas.j2ee6.jax.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;

import es.pruebas.j2ee6.jax.ws.model.Entrada;
import es.pruebas.j2ee6.jax.ws.model.Justificante;

@WebService
public class RegistroTelematicoServiceImple implements RegistroTelematicoService {

	@Override
	@WebMethod
	public Justificante registrarEntrada(Entrada entrada) {
		Justificante justificante = new Justificante();
		justificante.setNumeroRegistro(100);
		
		return justificante;
	}
}

package es.pruebas.j2ee6.jax.ws;

import es.pruebas.j2ee6.jax.ws.model.Entrada;
import es.pruebas.j2ee6.jax.ws.model.Justificante;

public interface RegistroTelematicoService {
	
	public Justificante registrarEntrada (Entrada entrada);
}

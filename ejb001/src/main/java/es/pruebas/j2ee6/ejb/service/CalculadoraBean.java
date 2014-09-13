package es.pruebas.j2ee6.ejb.service;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Calculadora.class)
public class CalculadoraBean implements Calculadora {

	@Override
	public Float sumar(Float a, Float b) {		
		return a + b;
	}
	
}

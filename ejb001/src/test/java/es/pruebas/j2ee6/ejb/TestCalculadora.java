package es.pruebas.j2ee6.ejb;

import static org.junit.Assert.*;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.pruebas.j2ee6.ejb.service.Calculadora;

/**
 * @author EMILIO
 *
 */
public class TestCalculadora {
	private EJBContainer ec;
    private Context ctx;
	
	@Before
	public void setUp() {
	    ec = EJBContainer.createEJBContainer();
	    ctx = ec.getContext();
	}
	
	@After
	public void tearDown() {
		if (ec != null) {
			ec.close();
		}
	}
   
    @Test
    public void testCalculadora() throws Exception {
    	Calculadora calculadora = (Calculadora) ctx.lookup("java:global/classes/CalculadoraBean");
    	Float valor = calculadora.sumar(50f, 30f);
    	assertEquals(new Float(80), valor);
    }
}

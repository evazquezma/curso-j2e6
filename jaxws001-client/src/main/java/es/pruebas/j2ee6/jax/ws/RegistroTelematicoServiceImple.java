
package es.pruebas.j2ee6.jax.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "RegistroTelematicoServiceImple", targetNamespace = "http://ws.jax.j2ee6.pruebas.es/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RegistroTelematicoServiceImple {


    /**
     * 
     * @param arg0
     * @return
     *     returns es.pruebas.j2ee6.jax.ws.Justificante
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "registrarEntrada", targetNamespace = "http://ws.jax.j2ee6.pruebas.es/", className = "es.pruebas.j2ee6.jax.ws.RegistrarEntrada")
    @ResponseWrapper(localName = "registrarEntradaResponse", targetNamespace = "http://ws.jax.j2ee6.pruebas.es/", className = "es.pruebas.j2ee6.jax.ws.RegistrarEntradaResponse")
    public Justificante registrarEntrada(
        @WebParam(name = "arg0", targetNamespace = "")
        Entrada arg0);

}
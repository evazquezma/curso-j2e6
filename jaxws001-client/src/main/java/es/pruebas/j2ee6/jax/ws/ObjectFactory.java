
package es.pruebas.j2ee6.jax.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the es.pruebas.j2ee6.jax.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistrarEntradaResponse_QNAME = new QName("http://ws.jax.j2ee6.pruebas.es/", "registrarEntradaResponse");
    private final static QName _RegistrarEntrada_QNAME = new QName("http://ws.jax.j2ee6.pruebas.es/", "registrarEntrada");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: es.pruebas.j2ee6.jax.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Entrada }
     * 
     */
    public Entrada createEntrada() {
        return new Entrada();
    }

    /**
     * Create an instance of {@link RegistrarEntradaResponse }
     * 
     */
    public RegistrarEntradaResponse createRegistrarEntradaResponse() {
        return new RegistrarEntradaResponse();
    }

    /**
     * Create an instance of {@link Justificante }
     * 
     */
    public Justificante createJustificante() {
        return new Justificante();
    }

    /**
     * Create an instance of {@link RegistrarEntrada }
     * 
     */
    public RegistrarEntrada createRegistrarEntrada() {
        return new RegistrarEntrada();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarEntradaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jax.j2ee6.pruebas.es/", name = "registrarEntradaResponse")
    public JAXBElement<RegistrarEntradaResponse> createRegistrarEntradaResponse(RegistrarEntradaResponse value) {
        return new JAXBElement<RegistrarEntradaResponse>(_RegistrarEntradaResponse_QNAME, RegistrarEntradaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrarEntrada }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.jax.j2ee6.pruebas.es/", name = "registrarEntrada")
    public JAXBElement<RegistrarEntrada> createRegistrarEntrada(RegistrarEntrada value) {
        return new JAXBElement<RegistrarEntrada>(_RegistrarEntrada_QNAME, RegistrarEntrada.class, null, value);
    }

}

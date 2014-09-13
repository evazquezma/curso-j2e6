package es.pruebas.j2ee6.jax.rs;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

import es.pruebas.j2ee6.jax.rs.model.Entrada;
import es.pruebas.j2ee6.jax.rs.model.Justificante;

/**
 * REST Web Service
 *
 */

@Path("/helloworld")
public class HelloWorld {
    @Context
    private UriInfo context;

    /** Creates a new instance of HelloWorld */
    public HelloWorld() {
    }

    
    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/html")
    public String getHtml() {
        return "<html lang=\"en\"><body><h1>Hello, World!!</h1></body></html>";
    }  
    
    
    
    @GET
    @Path("/registroJSON")
    @Produces("application/json")
    public Justificante getJson(Entrada entrada) {
    	Justificante justificante = new Justificante();
    	justificante.setNumeroRegistro(50);
        return justificante;
    }
    
    
    @GET
    @Path("/registroJSON/{nombreDoc}")
    @Produces("application/json")
    public Justificante getXML(@PathParam("nombreDoc") String nombreDoc) {
    	System.out.println("Recibido nombre de documento " + nombreDoc);
    	
    	Justificante justificante = new Justificante();
    	justificante.setNumeroRegistro(50);
        return justificante;
    }
    
    
    
    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}

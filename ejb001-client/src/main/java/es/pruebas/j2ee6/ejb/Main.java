package es.pruebas.j2ee6.ejb;

import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;

import es.pruebas.j2ee6.ejb.model.Item;
import es.pruebas.j2ee6.ejb.service.Calculadora;
import es.pruebas.j2ee6.ejb.service.Carrito;
import es.pruebas.j2ee6.ejb.service.Hora;

public class Main {
	
	public static void main(String[] args) {
		  Properties props = new Properties();
		  /*
		  Sólo se necesitan especificar estas propiedades cuando el EJB se ejecuta en otro contenedor.
		  En este caso es todo glassfish.
		  
          props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
          props.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
          props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		*/
		
          Carrito carrito = null;
          Carrito carrito2 = null;
          Calculadora calculadora = null;
          Hora hora = null;
		  try{	          	           
			  InitialContext ctx = new InitialContext(props);
			  carrito = (Carrito) ctx.lookup("java:global/ejb001/CarritoBean");
			  carrito2 = (Carrito) ctx.lookup("java:global/ejb001/CarritoBean");
			  calculadora = (Calculadora) ctx.lookup("java:global/ejb001/CalculadoraBean");			  
			  hora = (Hora) ctx.lookup("java:global/ejb001/HoraBean");
		  } 
		  catch (Exception e) {
				e.printStackTrace();
				System.exit(-1);
		  }
		  
		  Item item = new Item();
		  item.setNombre("Articulo 1");
		  item.setPrecio(100f);
		  item.setCantidad(10);		  
		  carrito.addItem(item);
		  
		  item = new Item();
		  item.setNombre("Articulo 2");
		  item.setPrecio(35f);
		  item.setCantidad(5);		  
		  carrito.addItem(item);
		  
		  item = new Item();
		  item.setNombre("Articulo 3");
		  item.setPrecio(20f);
		  item.setCantidad(2);		  
		  carrito.addItem(item);
		  
		  List<Item> items = carrito.getItems();
		  for (Item unItem : items) {
			  System.out.println(unItem);
		  }
		 System.out.println("Items del carrito: " + carrito.getItems().size());
		 System.out.println("Importe total: " + carrito.getTotal());
		 System.out.println("Items del carrito 2: " + carrito2.getItems().size());
		 
		 System.out.println("Resultado calculadora: " + calculadora.sumar(10f, 30f));
		 
		 System.out.println("Son las " + hora.queHoraEs());
		
	}

}

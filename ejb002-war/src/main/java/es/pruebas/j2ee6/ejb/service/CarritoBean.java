package es.pruebas.j2ee6.ejb.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import es.pruebas.j2ee6.ejb.model.Item;

@Stateful
@Remote(Carrito.class)
public class CarritoBean implements Carrito{
	private List<Item> items;
	
	@EJB
	private Calculadora calculadora;
	
	
	@PostConstruct
	private void postConstruct() {
		System.out.println("El contenedor llama a postConstruct del bean CarritoBean");
		items = new ArrayList<Item>();		
	}
	
	@PrePassivate
	public void prePassivate() {
		System.out.println("El contenedor va a desactivar el bean CarritoBean");
	}
	
	@PostActivate
	public void preActivate() {
		System.out.println("El contendor acaba de reactivar el bean CarritoBean");
	}
	
	@Remove
	public void remove() {
		System.out.println("El cliente llama al remove del bean CarritoBean");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("El contendor va a destruir el bean CarritoBean");
	}
	
	
	
	
	
	
	@Override
	public void addItem(Item item) {
		items.add(item);		
	}

	@Override
	public List<Item> getItems() {		
		return items;
	}

	@Override
	public Float getTotal() {
		float total = 0;
		for (Item item : items) {
			total = calculadora.sumar(total, item.getCantidad() * item.getPrecio());
		}		
		
		return total;
	}

}

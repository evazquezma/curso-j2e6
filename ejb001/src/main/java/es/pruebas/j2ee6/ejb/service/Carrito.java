package es.pruebas.j2ee6.ejb.service;

import java.util.List;

import es.pruebas.j2ee6.ejb.model.Item;

public interface Carrito {
	public void addItem(Item item);
	
	public List<Item> getItems();
	
	public Float getTotal();
}

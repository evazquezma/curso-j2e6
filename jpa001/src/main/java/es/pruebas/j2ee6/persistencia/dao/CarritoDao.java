package es.pruebas.j2ee6.persistencia.dao;

import java.util.List;

import es.pruebas.j2ee6.model.Item;

public interface CarritoDao {

	public void addItem(Long idUsuario, Item item);

	public List<Item> getItemsUsuario(Long idUsuario);

}

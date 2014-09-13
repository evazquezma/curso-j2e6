package es.pruebas.j2ee6.persistencia.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.pruebas.j2ee6.model.Item;
import es.pruebas.j2ee6.persistencia.model.ItemEntity;

@Stateless
@Remote(CarritoDao.class)
public class CarritoDaoBean implements CarritoDao {
	
	@PersistenceContext(unitName="carritoPU")
	private EntityManager em;
	
	
	
	
	@Override
	public void addItem(Long idUsuario, Item item) {
		ItemEntity itemEntity = new ItemEntity();
		itemEntity.setIdUsuario(idUsuario);
		itemEntity.setNombre(item.getNombre());
		itemEntity.setCantidad(item.getCantidad());
		itemEntity.setPrecio(item.getPrecio());
		
		em.persist(itemEntity);
	}
	
	
	@Override
	public List<Item> getItemsUsuario(Long idUsuario){
		List<Item> items = new ArrayList<Item>();
		
		
		@SuppressWarnings("unchecked")
		List<ItemEntity> itemsEntity = em.createQuery(
		        "SELECT i FROM ItemEntity i WHERE i.idUsuario = :idUsuario")
		        .setParameter("idUsuario", idUsuario)
		        .getResultList();
		
		for (ItemEntity itemEntity : itemsEntity) {
			Item item = new Item();
			item.setNombre(itemEntity.getNombre());
			item.setCantidad(itemEntity.getCantidad());
			item.setPrecio(itemEntity.getPrecio());
			items.add(item);
		}
		
		return items;
	}
}

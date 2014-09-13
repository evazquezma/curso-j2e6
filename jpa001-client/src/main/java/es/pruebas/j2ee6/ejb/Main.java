package es.pruebas.j2ee6.ejb;

import java.util.List;
import java.util.Properties;

import javax.naming.InitialContext;

import es.pruebas.j2ee6.model.Item;
import es.pruebas.j2ee6.persistencia.dao.CarritoDao;

public class Main {

	public static void main(String[] args) {

		CarritoDao carritoDao = null;
		try {
			InitialContext ctx = new InitialContext();
			carritoDao = (CarritoDao) ctx.lookup("java:global/jpa001/CarritoDaoBean");
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}

		Item item = new Item();
		item.setNombre("Articulo 1 - usuario 1");
		item.setPrecio(100f);
		item.setCantidad(10);
		carritoDao.addItem(2l, item);

		item = new Item();
		item.setNombre("Articulo 2 - usuario 1");
		item.setPrecio(35f);
		item.setCantidad(5);
		carritoDao.addItem(2l, item);

		
		
		List<Item> items = carritoDao.getItemsUsuario(2l);
		for (Item unItem : items) {
			System.out.println(unItem);
		}
	}

}

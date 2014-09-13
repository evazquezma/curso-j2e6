package es.pruebas.j2ee6.model;

import java.io.Serializable;

public class Item implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2989459210214712209L;
	
	
	private String nombre;
	private Integer cantidad;
	private Float precio;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	
	
	@Override
	public String toString() {
		return "Item [nombre=" + nombre + ", cantidad=" + cantidad
				+ ", precio=" + precio + "]";
	}	
}

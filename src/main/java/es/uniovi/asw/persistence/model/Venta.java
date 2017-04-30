package es.uniovi.asw.persistence.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Venta")
public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Articulo articulo;
	@ManyToOne
	private Tienda tienda;
	private int unidades;
	private double precioTotal;
	private Date fecha;
	
	public Venta() {}


	public Venta(Articulo articulo, Tienda tienda, int unidades, double precioTotal, Date fecha) {
		this.articulo = articulo;
		this.tienda = tienda;
		this.unidades = unidades;
		this.precioTotal = precioTotal;
		this.fecha = fecha;
	}



	public Articulo getArticulo() {
		return articulo;
	}



	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}



	public Tienda getTienda() {
		return tienda;
	}



	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}



	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
//		precioTotal=articulo.getPrecio()*unidades;
		this.precioTotal = precioTotal;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	

}

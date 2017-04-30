package es.uniovi.asw.persistence.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="Articulo")
public class Articulo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String descripcion;
	private int unidades;
	private double precio;
	@OneToMany(mappedBy="articulo", fetch = FetchType.EAGER)
	private List<Venta> ventas= new ArrayList<Venta>();
	
	
	public Articulo(){}
	
	
	public Articulo(String nombre, String descripcion, int unidades, double precio) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.unidades = unidades;
		this.precio = precio;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getUnidades() {
		return unidades;
	}
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public List<Venta> getVentas() {
		return ventas;
	}


	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}





	@Override
	public String toString() {
		return nombre;
	}



	


}

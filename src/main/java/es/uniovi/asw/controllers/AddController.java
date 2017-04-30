package es.uniovi.asw.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Articulo;
import es.uniovi.asw.persistence.model.Tienda;
import es.uniovi.asw.persistence.model.Venta;




@Component("addArticulo")
@Scope("request")
public class AddController {

	@Autowired
	private Factories factoria;
	private Articulo articulo;
	private String nombre;
	private String descripcion;
	private int unidades;
	private double precio;
	private Tienda tienda;
	private String direccion;
	private int telefono;
	private List<Articulo> articulos;
	private List<Tienda> tiendas;
	private Venta venta;
	private String tiendaNombre;
	private String articuloNombre;


	@PostConstruct
	public void init() {
		articulos= factoria.getServicesFactory().getArticuloService().findAll();
		tiendas= factoria.getServicesFactory().getTiendaService().findAll();
	}

	public String addArticulo(){

		articulo=new Articulo(nombre, descripcion, unidades, precio);

		factoria.getServicesFactory().getArticuloService().save(articulo);
		return "success";
	}
	public String addTienda(){

		tienda=new Tienda(nombre, direccion, telefono);
		factoria.getServicesFactory().getTiendaService().save(tienda);
		return "success";
	}
	public String addVenta(){
		
		articulo= factoria.getPersistenceFactory().getArticuloRepository().findByNombre(articuloNombre);
		tienda= factoria.getPersistenceFactory().getTiendaRepository().findByNombre(tiendaNombre);
		venta=new Venta(articulo, tienda, unidades, precio, new Date());
		factoria.getServicesFactory().getVentaService().save(venta);
		return "success";
	}
	public String showNuevoArticulo(){
		return "success";
	}
	public String showNuevaVenta(){
		return "success";
	}
	public String showNuevaTienda(){
		return "success";
	}


	public Factories getFactoria() {
		return factoria;
	}


	public void setFactoria(Factories factoria) {
		this.factoria = factoria;
	}


	public Articulo getArticulo() {
		return articulo;
	}


	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
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
	public Tienda getTienda() {
		return tienda;
	}
	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	public List<Tienda> getTiendas() {
		return tiendas;
	}
	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public String getTiendaNombre() {
		return tiendaNombre;
	}

	public void setTiendaNombre(String tiendaNombre) {
		this.tiendaNombre = tiendaNombre;
	}

	public String getArticuloNombre() {
		return articuloNombre;
	}

	public void setArticuloNombre(String articuloNombre) {
		this.articuloNombre = articuloNombre;
	}

}

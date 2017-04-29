package es.uniovi.asw.controllers;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Articulo;
import es.uniovi.asw.persistence.model.Tienda;
import es.uniovi.asw.persistence.model.Venta;
import es.uniovi.asw.persistence.model.ss.Citizen;

@Component("VentasController")
@Scope("session")
public class addVenta {
	private Citizen citizen;
	private List<Venta> ventas;
	private Articulo articulo;
	private Tienda tienda;
	private int unidades;
	private double precioTotal;
	private Date date;
	
	@Autowired
	private Factories factoria;

	@PostConstruct
	public void init() {
		ventas= factoria.getServicesFactory().getVentaService().findAll();
		citizen=(Citizen) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");

	}
	public List<Venta> showVentas()
	{
		 ventas = factoria.getServicesFactory().getVentaService().findAll();
		return ventas;
	}

	public Citizen getCitizen() {
		return citizen;
	}

	public void setCitizen(Citizen citizen) {
		this.citizen = citizen;
	}

	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
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
		this.precioTotal = precioTotal;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}

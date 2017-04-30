package es.uniovi.asw.controllers;

import java.util.ArrayList;
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
import es.uniovi.asw.persistence.model.ss.Proposal;

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
	private List<String> articulosName=new ArrayList<String>();
	private List<String> tiendasName=new ArrayList<String>();
	private Venta ventaSeleccionada;
	
	@Autowired
	private Factories factoria;

	@PostConstruct
	public void init() {
		ventas= factoria.getServicesFactory().getVentaService().findAll();
		citizen=(Citizen) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
		for (Venta venta : ventas) {
			articulosName.add(venta.getArticulo().getNombre());
			tiendasName.add(venta.getTienda().getNombre());
			
		}

	}
	public String ventaSeleccionada(Venta v)
	{
		ventaSeleccionada=v;
		articulo=ventaSeleccionada.getArticulo();
		tienda=ventaSeleccionada.getTienda();
		unidades=ventaSeleccionada.getUnidades();
		precioTotal=ventaSeleccionada.getPrecioTotal();
		date=ventaSeleccionada.getFecha();
		
		return "goToView";
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
	public List<String> getArticulosName() {
		return articulosName;
	}
	public void setArticulosName(List<String> articulosName) {
		this.articulosName = articulosName;
	}
	public List<String> getTiendasName() {
		return tiendasName;
	}
	public void setTiendasName(List<String> tiendasName) {
		this.tiendasName = tiendasName;
	}
	public Venta getVentaSeleccionada() {
		return ventaSeleccionada;
	}
	public void setVentaSeleccionada(Venta ventaSeleccionada) {
		this.ventaSeleccionada = ventaSeleccionada;
	}

}

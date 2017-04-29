package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.Venta;

public interface VentaService {
	void save(Venta venta);
	void delete(Venta venta);
	List<Venta> findAll();

}

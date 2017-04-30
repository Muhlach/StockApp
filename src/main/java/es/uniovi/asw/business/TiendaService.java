package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.Tienda;

public interface TiendaService {
	void save(Tienda tienda);
	void delete(Tienda tienda);
	List<Tienda> findAll();

}

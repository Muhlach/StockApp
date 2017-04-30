package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.Articulo;

public interface ArticuloService {
	void save(Articulo articulo);
	void delete(Articulo articulo);
	List<Articulo> findAll();

}

package es.uniovi.asw.business;

import es.uniovi.asw.persistence.model.Articulo;

public interface ArticuloService {
	void save(Articulo articulo);
	void delete(Articulo articulo);

}

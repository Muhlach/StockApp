package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.ArticuloService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Articulo;

@Service
public class ArticuloServiceImpl implements ArticuloService{
	
	@Autowired
	private Factories factories;

	@Override
	public void save(Articulo articulo) {
		factories.getPersistenceFactory().getArticuloRepository().save(articulo);
	}

	@Override
	public void delete(Articulo articulo) {
		factories.getPersistenceFactory().getArticuloRepository().delete(articulo);
		
	}

}

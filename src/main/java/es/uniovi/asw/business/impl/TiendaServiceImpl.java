package es.uniovi.asw.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.TiendaService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Tienda;


@Service
public class TiendaServiceImpl implements TiendaService{
	@Autowired
	private Factories factories;

	@Override
	public void save(Tienda tienda) {
		factories.getPersistenceFactory().getTiendaRepository().save(tienda);
		
	}

	@Override
	public void delete(Tienda tienda) {
		factories.getPersistenceFactory().getTiendaRepository().delete(tienda);
		
	}

}

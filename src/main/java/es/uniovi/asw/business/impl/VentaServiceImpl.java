package es.uniovi.asw.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.business.VentaService;
import es.uniovi.asw.infraestructure.Factories;
import es.uniovi.asw.persistence.model.Venta;

@Service
public class VentaServiceImpl implements VentaService{
	
	@Autowired
	private Factories factories;

	@Override
	public void save(Venta venta) {
		factories.getPersistenceFactory().getVentaRepository().save(venta);
		
	}

	@Override
	public void delete(Venta venta) {
		factories.getPersistenceFactory().getVentaRepository().delete(venta);
		
	}

	@Override
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return factories.getPersistenceFactory().getVentaRepository().findAll();
	}

}

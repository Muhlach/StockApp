package es.uniovi.asw.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.persistence.model.Articulo;

public interface ArticuloRepository extends JpaRepository<Articulo, Long>{


	Articulo findByNombre(String articuloNombre);

}

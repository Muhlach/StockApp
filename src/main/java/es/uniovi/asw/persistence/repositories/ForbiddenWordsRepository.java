package es.uniovi.asw.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.persistence.model.ss.ForbiddenWords;

public interface ForbiddenWordsRepository extends JpaRepository<ForbiddenWords, Long>{

}

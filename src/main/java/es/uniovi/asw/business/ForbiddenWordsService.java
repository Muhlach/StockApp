package es.uniovi.asw.business;

import java.util.List;

import es.uniovi.asw.persistence.model.ss.Category;
import es.uniovi.asw.persistence.model.ss.Configuration;
import es.uniovi.asw.persistence.model.ss.ForbiddenWords;

public interface ForbiddenWordsService {
	
	void save(ForbiddenWords word);
	void remove(ForbiddenWords word);
	List<ForbiddenWords> findAll();

}

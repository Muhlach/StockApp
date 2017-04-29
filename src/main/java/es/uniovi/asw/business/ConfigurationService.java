package es.uniovi.asw.business;


import java.util.Set;

import es.uniovi.asw.persistence.model.ss.Configuration;
import es.uniovi.asw.persistence.model.ss.ForbiddenWords;

public interface ConfigurationService {

	void save(Configuration conf);
	void delete(Configuration conf);
	
	Configuration actualConfiguration();
	Set<ForbiddenWords> getForbiddenWords(Configuration conf);
}

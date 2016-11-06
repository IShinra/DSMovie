package it.dstech.film.service;

import it.dstech.film.model.Genere;

public interface GenereDao {
	
	Genere findById(int id);
	
	void save(Genere genere);

}

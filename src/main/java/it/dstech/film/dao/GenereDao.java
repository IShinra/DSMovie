package it.dstech.film.dao;

import it.dstech.film.model.Genere;

public interface GenereDao {
	
	Genere findById(int id);
	
	void save(Genere genere);

}

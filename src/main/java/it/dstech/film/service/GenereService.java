package it.dstech.film.service;

import it.dstech.film.model.Genere;

public interface GenereService {
	
	Genere findById(int id);
	
	void save(Genere genere);

}

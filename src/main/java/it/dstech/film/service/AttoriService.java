package it.dstech.film.service;

import java.util.List;

import it.dstech.film.model.Attore;

public interface AttoriService {


	List<Attore> findAllAttori();
	
	Attore findById(int id);

	Attore findByNome(String nome);
	
	Attore findByCognome(String nome);

	void save(Attore attore);

	void deleteById(int id);

}

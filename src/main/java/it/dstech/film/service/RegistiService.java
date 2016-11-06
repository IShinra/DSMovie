package it.dstech.film.service;

import java.util.List;

import it.dstech.film.model.Regista;

public interface RegistiService {

	List<Regista> findAllRegisti();

	Regista findById(int id);

	Regista findByNome(String nome);

	Regista findByCognome(String cognome);

	void save(Regista regista);
	
	void deleteById(int id);

}

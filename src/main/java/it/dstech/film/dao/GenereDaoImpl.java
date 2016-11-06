package it.dstech.film.dao;


import org.springframework.stereotype.Repository;

import it.dstech.film.model.Genere;
@Repository("genereDao")
public class GenereDaoImpl extends AbstractDao implements GenereDao{

	public Genere findById(int id) {
		Genere genere = (Genere) findById(id);
		return genere;
	}

	public void save(Genere genere) {
		persist(genere);
	}

}

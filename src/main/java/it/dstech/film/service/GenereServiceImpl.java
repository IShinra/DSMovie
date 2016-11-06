package it.dstech.film.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.film.model.Genere;
@Service("genereService")
@Transactional
public class GenereServiceImpl implements GenereService{

	@Autowired
	GenereService dao;
	
	public Genere findById(int id) {
		return dao.findById(id);
	}

	public void save(Genere genere) {
		dao.save(genere);
	}

}

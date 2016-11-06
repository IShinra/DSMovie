package it.dstech.film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.film.model.Attore;

@Service("attoriService")
@Transactional
public class AttoriDaoImpl implements AttoriDao {

	@Autowired
	AttoriDao dao;

	public List<Attore> findAllAttori() {
		return dao.findAllAttori();
	}

	public Attore findById(int id) {
		return dao.findById(id);
	}

	public Attore findByNome(String nome) {
		return dao.findByNome(nome);
	}

	public Attore findByCognome(String cognome) {
		return dao.findByCognome(cognome);
	}

	public void save(Attore attore) {
		dao.save(attore);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

}

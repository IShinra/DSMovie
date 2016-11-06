package it.dstech.film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.film.model.Regista;

@Service("registiService")
@Transactional
public class RegistiDaoImpl implements RegistiDao {

	@Autowired
	RegistiDao dao;

	public List<Regista> findAllRegisti() {
		return dao.findAllRegisti();
	}

	public Regista findById(int id) {
		return dao.findById(id);
	}

	public Regista findByNome(String nome) {
		return dao.findByNome(nome);
	}

	public Regista findByCognome(String cognome) {
		return dao.findByCognome(cognome);
	}

	public void save(Regista regista) {
		dao.save(regista);

	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}

}

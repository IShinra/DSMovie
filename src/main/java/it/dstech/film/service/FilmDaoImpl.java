package it.dstech.film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.film.model.Film;

@Service("filmService")
@Transactional
public class FilmDaoImpl implements FilmDao {
	@Autowired
	FilmDao dao;

	public List<Film> findAllFilms() {
		return dao.findAllFilms();
	}

	public Film findById(int id) {
		return dao.findById(id);
	}

	public Film findByAttore(String nome) {
		return dao.findByAttore(nome);
	}

	public Film findByRegista(String nome) {
		return dao.findByRegista(nome);
	}

	public Film findByGenere(String nome) {
		return dao.findByGenere(nome);
	}

	public void save(Film film) {
		dao.save(film);

	}

	public void deleteById(int id) {
		dao.deleteById(id);

	}

	public void update(Film film) {
		dao.update(film);
	}

	public Film findByTitolo(String titolo) {
		return dao.findByTitolo(titolo);

	}

}

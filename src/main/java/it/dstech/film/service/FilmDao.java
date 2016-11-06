package it.dstech.film.service;

import java.util.List;

import it.dstech.film.model.Film;

public interface FilmDao {
	
	List<Film> findAllFilms();
	
	Film findById(int id);

	Film findByAttore(String nome);
	
	Film findByRegista(String nome);
	
	Film findByGenere(String nome);
	
	Film findByTitolo(String titolo);

	void save(Film film);

	void deleteById(int id);
	
	void update(Film film);

}

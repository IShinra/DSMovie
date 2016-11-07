package it.dstech.film.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.film.model.Film;
import it.dstech.film.service.FilmService;

@RestController
@RequestMapping("/film")
public class FilmController {

	@Autowired
	FilmService service;

	/**
	 * Get Model
	 */
	@RequestMapping(value = { "/getModel" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Film getFilmModel() {
		return new Film();
	}

	/**
	 * List Films
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Film> listFilms() {
		List<Film> film = service.findAllFilms();
		return film;
	}

	/**
	 * Find Film by Id
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/id={id}" }, method = RequestMethod.GET)
	public Film getFilmById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	/**
	 * Find Film by Titolo
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/titolo={titolo}" }, method = RequestMethod.GET)
	public Film getFilmByTitolo(@PathVariable("titolo") String titolo) {
		return service.findByTitolo(titolo);
	}

	/**
	 * Find Film by Attore
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/attore={nome}" }, method = RequestMethod.GET)
	public Film getFilmByAttore(@PathVariable("nome") String nome) {
		return service.findByAttore(nome);
	}

	/**
	 * Find Film by Regista
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/regista={nome}" }, method = RequestMethod.GET)
	public Film getFilmByRegista(@PathVariable("nome") String nome) {
		return service.findByRegista(nome);
	}

	/**
	 * Find Film by Genere
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/genere={nome}" }, method = RequestMethod.GET)
	public Film getFilmByGenere(@PathVariable("nome") String nome) {
		return service.findByGenere(nome);
	}

	/**
	 * Create new Film
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Film film) {
		service.save(film);
	}

	/**
	 * Delete Film by Id
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/delete/id={id}" }, method = RequestMethod.DELETE)
	public void deleteFilmById(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}

	/**
	 * Update Film 
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/delete/id={id}" }, method = RequestMethod.DELETE)
	public void updateFilm(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}
}

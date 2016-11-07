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

import it.dstech.film.model.Attore;
import it.dstech.film.service.AttoriService;

@RestController
@RequestMapping("/attore")
public class AttoreController {

	@Autowired
	AttoriService service;

	/**
	 * Get Model
	 */
	@RequestMapping(value = { "/getModel" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Attore getAttoreModel() {
		return new Attore();
	}

	/**
	 * List Attori
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Attore> listAttori() {
		List<Attore> attore = service.findAllAttori();
		return attore;
	}

	/**
	 * Find Attore by Id
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/id={id}" }, method = RequestMethod.GET)
	public Attore getAttoreById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	/**
	 * Find Attore by Nome
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/nome={nome}" }, method = RequestMethod.GET)
	public Attore getAttoreByNome(@PathVariable("nome") String nome) {
		return service.findByNome(nome);
	}

	/**
	 * Find Attore by Cognome
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/cognome={cognome}" }, method = RequestMethod.GET)
	public Attore getAttoreByCognome(@PathVariable("cognome") String cognome) {
		return service.findByNome(cognome);
	}

	/**
	 * Create new Attore
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Attore attore) {
		service.save(attore);
	}

	/**
	 * Delete by Id
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/delete/id={id}" }, method = RequestMethod.DELETE)
	public void deleteAttoreById(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}
}

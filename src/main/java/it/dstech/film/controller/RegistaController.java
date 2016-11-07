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

import it.dstech.film.model.Regista;
import it.dstech.film.service.RegistiService;

@RestController
@RequestMapping("/regista")
public class RegistaController {
	@Autowired
	RegistiService service;

	/**
	 * Get Model
	 */
	@RequestMapping(value = { "/getModel" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Regista getRegistaModel() {
		return new Regista();
	}

	/**
	 * List Registi
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Regista> listRegisti() {
		List<Regista> regista = service.findAllRegisti();
		return regista;
	}

	/**
	 * Find Registi by Id
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/id={id}" }, method = RequestMethod.GET)
	public Regista getRegistiById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}

	/**
	 * Find Registi by Nome
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/titolo={nome}" }, method = RequestMethod.GET)
	public Regista getRegistiByNome(@PathVariable("titolo") String nome) {
		return service.findByNome(nome);
	}

	/**
	 * Find Registi by Cognome
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/titolo={cognome}" }, method = RequestMethod.GET)
	public Regista getRegistiByCognome(@PathVariable("titolo") String cognome) {
		return service.findByCognome(cognome);
	}

	/**
	 * Create new Regista
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Regista regista) {
		service.save(regista);
	}

	/**
	 * Delete Regista by Id
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/delete/id={id}" }, method = RequestMethod.DELETE)
	public void deleteRegistaById(@PathVariable("id") Integer id) {
		service.deleteById(id);
	}
}

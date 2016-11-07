package it.dstech.film.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.dstech.film.model.Genere;
import it.dstech.film.service.GenereService;

@RestController
@RequestMapping("/genere")
public class GenereController {
	@Autowired
	GenereService service;

	
	/**
	 * Find Genere by Id
	 */
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/get/id={id}" }, method = RequestMethod.GET)
	public Genere getGenereById(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Genere genere) {
		service.save(genere);
	}
}

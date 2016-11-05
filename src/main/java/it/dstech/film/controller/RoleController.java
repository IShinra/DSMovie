package it.dstech.film.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.dstech.film.model.Role;
import it.dstech.film.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	RoleService service;

	/**
	 * Return json model
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/getModel" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Role getRoleModel() {

		return new Role();
	}

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveRole(@RequestBody Role role) {

		service.saveRole(role);
	}

	/**
	 * List of roles
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Role> listUser() {

		List<Role> roles = service.findAllRoles();
		return roles;
	}
}

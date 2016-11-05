package it.dstech.film.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import it.dstech.film.model.Role;
import it.dstech.film.model.User;
import it.dstech.film.service.RoleService;
import it.dstech.film.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService serviceUser;
	@Autowired
	RoleService serviceRole;

	/**
	 * Return json model
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/getModel" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUserModel() {

		return new User();
	}

	/**
	 * List of user
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/list" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> listUser() {

		List<User> users = serviceUser.findAllUsers();
		return users;
	}

	/**
	 * Return an user by id
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = {
			"/getUser/{id}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserById(@PathVariable int id) {

		if (serviceUser.findById(id) != null)
			return new ResponseEntity<User>(serviceUser.findById(id), HttpStatus.OK);
		else
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);

	}

	/**
	 * Save new user
	 * 
	 * @param user
	 */
	@RequestMapping(value = { "/save" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUser(@RequestBody User user) {

		List<Role> roles = user.getRoles(); // ruoli dell'utente
		List<Role> roles_db = serviceRole.findAllRoles(); // ruoli presenti ne db.

		for (int i = 0; i < roles.size(); i++) {
			for (int j = 0; j < roles_db.size(); j++) {
				Role app = roles.get(i);
				Role app_2 = roles_db.get(j);
				if (app.getRole().toString().equals(app_2.getRole().toString())) { // confronto dei ruoli sul db con quelli dell'utente
					roles.set(i, roles_db.get(j));
				}
			}

		}
		user.setRoles(roles); // aggiorno l'utente con la lista dei suoi ruoli.
		serviceUser.saveUser(user);
	}

	/**
	 * Update an user
	 * 
	 * @param user
	 * @param id
	 */

	@RequestMapping(value = { "/saveh" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void saveUserHeader(@RequestHeader(value = "name") String name,
			@RequestHeader(value = "username") String username) {

		User user = new User();

		user.setNome(name);
		user.setUsername(username);

		serviceUser.saveUser(user);

	}

	@RequestMapping(value = { "/update" }, method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateUser(@RequestBody User user) {
		serviceUser.updateUser(user);
	}

	/*
	 * Delete an user by id
	 * 
	 * @param id
	 */

	@RequestMapping(value = { "/delete/{id}" }, method = RequestMethod.DELETE)
	public void deleteUserById(@PathVariable int id) {

		serviceUser.deleteUserById(id);
	}

}

package it.dstech.film.service;

import java.util.List;
import it.dstech.film.model.Role;

public interface RoleService {

	Role findById(int id);

	Role findByType(String type);

	void saveRole(Role role);

	List<Role> findAllRoles();

}

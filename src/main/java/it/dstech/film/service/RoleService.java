package it.dstech.film.service;

import java.util.List;
import it.dstech.film.model.Role;

public interface RoleService {

	List<Role> findAllRoles();

	List<Role> findAllAdmin(String type);

	List<Role> findAllDba(String type);

	Role findByType(String type);

	Role findById(int id);
}

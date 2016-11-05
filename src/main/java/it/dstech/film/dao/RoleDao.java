package it.dstech.film.dao;

import java.util.List;

import it.dstech.film.model.Role;

public interface RoleDao {

	List<Role> findAllRoles();

	void save(Role role);

	Role findByType(String type);

	Role findById(int id);
}

package it.dstech.film.dao;

import java.util.List;

import it.dstech.film.model.Role;

public interface RoleDao {

	List<Role> findAllRoles();

	List<Role> findAllAdmin(String type);

	List<Role> findAllDba(String type);

	Role findByType(String type);

	Role findById(int id);
}

package it.dstech.film.dao;

import java.util.List;

import it.dstech.film.model.User;

public interface UserDao {

	User findById(int id);

	User findByUsername(String username);

	void save(User user);

	void deleteByUsername(String username);

	void deleteUserById(int id);

	List<User> findAllUsers();

}

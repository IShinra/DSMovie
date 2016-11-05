package it.dstech.film.service;

import java.util.List;

import it.dstech.film.model.User;

public interface UserService {

	User findById(int id);

	User findByUsername(String username);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserByUsername(String username);

	void deleteUserById(int id);

	List<User> findAllUsers();

	boolean isUserUsernameUnique(Integer id, String username);

}
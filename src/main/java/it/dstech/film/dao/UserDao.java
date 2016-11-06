package it.dstech.film.dao;

import java.util.List;

import it.dstech.film.model.User;

public interface UserDao {

	User findById(int id);

	User findByUsername(String username);

	void save(User user);

	void deleteByUsername(String username);
	
	void deleteByMail(String mail);

	void deleteUserById(int id);
	
	void updateById(int id);
	
	User findByMail(String mail);
	
	List<User> findAllUsers();

}

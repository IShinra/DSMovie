package it.dstech.film.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.dstech.film.dao.RoleDao;
import it.dstech.film.model.Role;

@Service("userProfileService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao dao;

	public Role findById(int id) {
		return dao.findById(id);
	}

	public Role findByType(String type) {
		return dao.findByType(type);
	}

	public List<Role> findAllRoles() {
		return dao.findAllRoles();
	}

	public void saveRole(Role role) {
		dao.save(role);
	}
}

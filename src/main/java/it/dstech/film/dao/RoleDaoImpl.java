package it.dstech.film.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import it.dstech.film.model.Role;

@Repository("userProfileDao")
public class RoleDaoImpl extends AbstractDao<Integer, Role> implements RoleDao {

	public Role findById(int id) {
		return getByKey(id);
	}

	public Role findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (Role) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Role> findAllRoles() {
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("role"));
		return (List<Role>) crit.list();
	}

	public void save(Role role) {
		persist(role);
	}
}

package it.dstech.film.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import it.dstech.film.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	public User findById(int id) {
		User user = getByKey(id);
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	public User findByUsername(String username) {
		logger.info("USERNAME : {}", username);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("username", username));
		User user = (User) crit.uniqueResult();
		if (user != null) {
			Hibernate.initialize(user.getRoles());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("nome"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		List<User> users = (List<User>) criteria.list();

		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteByUsername(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User) crit.uniqueResult();
		delete(user);
	}

	public void deleteUserById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		User user = (User) crit.uniqueResult();
		delete(user);
	}

	public void deleteByMail(String mail) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", mail));
		User user = (User) crit.uniqueResult();
		delete(user);
	}

	public void updateById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		User user = (User) crit.uniqueResult();
		update(user);
	}

	public User findByMail(String mail) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", mail));
		return (User) crit.uniqueResult();
	}

}

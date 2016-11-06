package it.dstech.film.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.dstech.film.model.Attore;
@Repository("attoriDao")
public class AttoriDaoImpl extends AbstractDao implements AttoriDao{

	public List<Attore> findAllAttori() {
		Criteria crit = getSession().createCriteria(Attore.class);
		return crit.list();
	}

	public Attore findById(int id) {
		Attore attore = (Attore)findById(id);
		return attore;
	}

	public Attore findByNome(String nome) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("nome", nome));
		Attore attore = (Attore)crit.uniqueResult();
		return attore;
	}

	public Attore findByCognome(String cognome) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("cognome", cognome));
		Attore attore = (Attore)crit.uniqueResult();
		return attore;
	}

	public void save(Attore attore) {
		persist(attore);
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Attore attore = (Attore)crit.uniqueResult();
		delete(attore);
	}

}

package it.dstech.film.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.dstech.film.model.Regista;
@Repository("registiDao")
public class RegistiDaoImpl extends AbstractDao implements RegistiDao{

	public Regista findById(int id) {
		Regista regista = (Regista) findById(id);
		return regista;
	}

	public Regista findByNome(String nome) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("nome", nome));
		return (Regista) crit.uniqueResult();
	}

	public Regista findByCognome(String cognome) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("cognome", cognome));
		return (Regista) crit.uniqueResult();
	}

	public void save(Regista regista) {
		persist(regista);		
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Regista regista = (Regista) crit.uniqueResult();
		delete(regista);
	}

	public List<Regista> findAllRegisti() {
		Criteria crit = getSession().createCriteria(Regista.class);
		return crit.list();
	}

}

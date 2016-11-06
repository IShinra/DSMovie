package it.dstech.film.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import it.dstech.film.model.Film;
@Repository("filmDao")
public class FilmDaoImpl extends AbstractDao implements FilmDao{

	public List<Film> findAllFilms() {
		Criteria crit = getSession().createCriteria(Film.class);
		return crit.list();
	}

	public Film findById(int id) {
		Film film = (Film) findById(id);
		return film;
	}

	public Film findByAttore(String nome) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("Attore.nome", nome));
		return (Film) crit.uniqueResult();
	}

	public Film findByRegista(String nome) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("Regista.nome", nome));
		return (Film) crit.uniqueResult();
	}

	public Film findByGenere(String nome) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("Genere.nome", nome));
		return (Film) crit.uniqueResult();
	}

	public void save(Film film) {
	persist(film);
	}

	public void deleteById(int id) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("id", id));
		Film film = (Film) crit.uniqueResult();
		delete(film);
	}

	public void update(Film film) {
		update(film);
	}

	public Film findByTitolo(String titolo) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("Film.titolo", titolo));
		return (Film) crit.uniqueResult();
	}

}

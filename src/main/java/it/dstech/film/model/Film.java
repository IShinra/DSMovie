package it.dstech.film.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@SuppressWarnings("serial")
@Entity
@Table(name = "Films")
public class Film implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private long id;
	private int durata, anno;
	private String titolo;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "attore_film", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "attore_id"))
	@JsonManagedReference
	private List<Attore> attore = new ArrayList<Attore>(0);

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "genere_film", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "genere_id"))
	@JsonManagedReference
	private List<Genere> genere = new ArrayList<Genere>(0);

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "regista_id")
	private Regista regista;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public long getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Attore> getAttore() {
		return attore;
	}

	public void setAttore(List<Attore> attore) {
		this.attore = attore;
	}

	public List<Genere> getGenere() {
		return genere;
	}

	public void setGenere(List<Genere> genere) {
		this.genere = genere;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}

}

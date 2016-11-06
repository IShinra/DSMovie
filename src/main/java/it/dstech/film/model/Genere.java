package it.dstech.film.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "Generi")
public class Genere implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genere_id")
	public long id;
	public String genere;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "genere")
	@JsonBackReference
	private List<Film> generefilm = new ArrayList<Film>(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public List<Film> getGenerefilm() {
		return generefilm;
	}

	public void setGenerefilm(List<Film> generefilm) {
		this.generefilm = generefilm;
	}

}

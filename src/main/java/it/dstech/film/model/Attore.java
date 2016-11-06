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
@Table(name = "Attori")
public class Attore implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attore_id")
	private long id;
	private String nome, cognome;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "attore")
	@JsonBackReference
	private List<Film> attorefilm = new ArrayList<Film>(0);

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Film> getAttorefilm() {
		return attorefilm;
	}

	public void setAttorefilm(List<Film> attorefilm) {
		this.attorefilm = attorefilm;
	}
}

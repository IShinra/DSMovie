package it.dstech.film.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@SuppressWarnings("serial")
@Entity
@Table(name = "Registi")
public class Regista implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "regista_id")
	private long id;
	private String nome, cognome;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regista")
	@JsonBackReference
	private List<Film> registafilm = new ArrayList<Film>();

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

	public List<Film> getRegistafilm() {
		return registafilm;
	}

	public void setRegistafilm(List<Film> registafilm) {
		this.registafilm = registafilm;
	}

}

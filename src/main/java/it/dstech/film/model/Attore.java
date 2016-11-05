package it.dstech.film.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Attori")
public class Attore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8545746463086619793L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attore_id")
	private long id;
	private String nome, cognome;

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
}

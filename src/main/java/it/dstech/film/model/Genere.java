package it.dstech.film.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Generi")
public class Genere implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8994447702601109543L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genere_id")
	public long id;
	public String genere;

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

}

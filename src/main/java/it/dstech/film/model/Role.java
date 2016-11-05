package it.dstech.film.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Roles")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Role.class)
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4488455620379413955L;
	@Id
	@GeneratedValue
	@Column(name = "role_id")
	private int id;
	@Enumerated(EnumType.STRING)
	private UserProfileType role;

	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private List<User> users = new ArrayList<User>();

	public UserProfileType getRole() {
		return role;
	}

	public void setRole(UserProfileType role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
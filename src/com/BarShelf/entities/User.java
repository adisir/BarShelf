package com.BarShelf.entities;

import java.util.ArrayList;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@Column(length = 50)
	private String email;
	@Column(length = 50, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String password;

	@ManyToMany(targetEntity = Ingredient.class)
	@JoinTable(name = "barshelf")
	private List<Ingredient> barshelf = new ArrayList<Ingredient>();

	public List<Ingredient> getBarshelf() {
		return barshelf;
	}

	public void setBarshelf(List<Ingredient> barshelf) {
		this.barshelf = barshelf;
	}

	// getters and setters
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

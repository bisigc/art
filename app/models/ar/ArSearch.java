package models.ar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import models.user.User;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class ArSearch {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String search;
	private String result;
	@ManyToOne
	@JsonBackReference(value="UserArSearches")
	private User user;

	// Getters and Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getSearch() { return search; }
	public void setSearch(String search) { this.search = search; }
	public String getResult() { return result; }
	public void setResult(String result) { this.result = result; }
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
}

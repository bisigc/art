package models.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="role")
	private List<User> users;
	@JsonIgnore
	@ManyToMany
	private List<Permission> permissions;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public List<User> getUsers() { return users; }
	public void setUsers(List<User> users) { this.users = users; }
}

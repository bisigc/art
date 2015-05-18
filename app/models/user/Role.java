package models.user;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import models.AbstractModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Data model representing a {@link Role}.
 * 
 * @author cbi
 */
@Entity
public class Role extends AbstractModel {

	private String name;
	private String description;
	@JsonIgnore
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="role")
	private List<User> users;
	@JsonIgnore
	@ManyToMany
	private List<Permission> permissions;

	//Getters & Setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public List<User> getUsers() { return users; }
	public void setUsers(List<User> users) { this.users = users; }
	public List<Permission> getPermissions() { return permissions; }
	public void setPermissions(List<Permission> permissions) { this.permissions = permissions; }
}

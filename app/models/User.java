package models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String surname;
	private String email;
	private String company;
	private String avatar;
	@ManyToOne
	private Role role;
	@OneToOne(cascade=CascadeType.PERSIST, mappedBy="user")
	private Digest digest;
	private Timestamp modified;
	private Timestamp created;
	
	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getFirstname() { return firstname; }
	public void setFirstname(String firstname) { this.firstname = firstname; }
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getCompany() { return company; }
	public void setCompany(String company) { this.company = company; }
	public String getAvatar() { return avatar; }
	public void setAvatar(String avatar) { this.avatar = avatar; }
	public Role getRole() { return role; }
	public void setRole(Role role) { this.role = role; }
	public Digest getDigest() { return digest; }
	public void setDigest(Digest digest) { this.digest = digest; }
	public Timestamp getModified() { return modified; }
	public void setModified(Timestamp modified) { this.modified = modified; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }	
}

package models.user;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Data model representing a {@link User}.
 * 
 * @author cbi
 */
@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String firstname;
	private String lastname;
	@Column(unique=true)
	private String email;
	private String organisation;
	private String avatar;
	private String startpage;
	private String homepage;
	@ManyToOne
	private Role role;
	@JsonIgnore
	@OneToOne(cascade=CascadeType.PERSIST, mappedBy="user")
	private Digest digest;
	private Timestamp modified;
	private Timestamp created;
		
	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getFirstname() { return firstname; }
	public void setFirstname(String firstname) { this.firstname = firstname; }
	public String getLastname() { return lastname; }
	public void setLastname(String surname) { this.lastname = surname; }
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getOrganisation() { return organisation; }
	public void setOrganisation(String organisation) { this.organisation = organisation; }
	public String getAvatar() { return avatar; }
	public void setAvatar(String avatar) { this.avatar = avatar; }
	public String getStartpage() { return startpage; }
	public void setStartpage(String startpage) { this.startpage = startpage; }
	public Role getRole() { return role; }
	public void setRole(Role role) { this.role = role; }
	public Digest getDigest() { return digest; }
	public void setDigest(Digest digest) { this.digest = digest; }
	public Timestamp getModified() { return modified; }
	public void setModified(Timestamp modified) { this.modified = modified; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
	public String getHomepage() { return homepage; }
	public void setHomepage(String homepage) { this.homepage = homepage; }
}
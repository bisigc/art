package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Digest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String salt;
	private String scrypt;
	@OneToOne
	private User user;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	public String getSalt() { return salt; }
	public void setSalt(String salt) { this.salt = salt; }
	public String getScrypt() { return scrypt; }
	public void setScrypt(String scrypt) { this.scrypt = scrypt; }
}

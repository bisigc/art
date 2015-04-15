package models;

import java.security.GeneralSecurityException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import utils.crypto.Crypto;

@Entity
public class Digest {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String salt;
	private String scrypt;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	public boolean isPasswordValid(String password) throws GeneralSecurityException {
		return Crypto.isPasswordValid(password, this);
	}
	
	public void generateDigest(String password) {
		Digest digest = Crypto.generateDigest(password);
		this.salt = digest.getSalt();
		this.scrypt = digest.getScrypt();
	}

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

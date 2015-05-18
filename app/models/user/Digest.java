package models.user;

import java.security.GeneralSecurityException;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import models.AbstractModel;
import utils.crypto.Crypto;

/**
 * Data model representing a {@link Digest}.
 * 
 * @author cbi
 */
@Entity
public class Digest extends AbstractModel {

	private String salt;
	private String scrypt;
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	/**
	 * Validates the given password with the current obects digests (salt and scrypt)
	 * using {@link Crypto} class. 
	 * 
	 * @param password
	 * @return
	 * @throws GeneralSecurityException
	 */
	public boolean isPasswordValid(String password) throws GeneralSecurityException {
		return Crypto.isPasswordValid(password, this);
	}
	
	/**
	 * Generates salt and digest (scrypt) with a given password
	 * using {@link Crypto} class.
	 * 
	 * @param password
	 */
	public void generateDigest(String password) {
		Digest digest = Crypto.generateDigest(password);
		this.salt = digest.getSalt();
		this.scrypt = digest.getScrypt();
	}

	//Getters & Setters
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	public String getSalt() { return salt; }
	public void setSalt(String salt) { this.salt = salt; }
	public String getScrypt() { return scrypt; }
	public void setScrypt(String scrypt) { this.scrypt = scrypt; }
}

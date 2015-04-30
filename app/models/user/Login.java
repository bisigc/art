package models.user;



/**
 * Data model representing a {@link Login}.
 * Has attribute email and password which is necessary
 * for login.
 * 
 * @author cbi
 */
public class Login {

	private String email;
	private String password;
	
	//Getters & Setters
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
}

package models.user;



/**
 * Data model representing a {@link NewPassword}.
 * Contains the necessary attributes to renew the password.
 * 
 * @author cbi
 */
public class NewPassword {

	private String currentpassword;
	private String newpassword;
	private String repeatpassword;
	
	//Getters & Setters
	public String getCurrentpassword() { return currentpassword; }
	public void setCurrentpassword(String currentpassword) { this.currentpassword = currentpassword; }
	public String getNewpassword() { return newpassword; }
	public void setNewpassword(String newpassword) { this.newpassword = newpassword; }
	public String getRepeatpassword() { return repeatpassword; }
	public void setRepeatpassword(String repeatpassword) { this.repeatpassword = repeatpassword; }
}

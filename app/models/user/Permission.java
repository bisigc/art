package models.user;

import javax.persistence.Entity;

import models.AbstractModel;

/**
 * Data model representing a {@link Permission}.
 * 
 * @author cbi
 */
@Entity
public class Permission extends AbstractModel {

	private String function;
	private String httpMethod;

	//Getters & Setters
	public String getFunction() { return function; }
	public void setFunction(String function) { this.function = function; }
	public String getHttpMethod() { return httpMethod; }
	public void setHttpMethod(String httpMethod) { this.httpMethod = httpMethod; }
}

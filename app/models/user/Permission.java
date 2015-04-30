package models.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Data model representing a {@link Permission}.
 * 
 * @author cbi
 */
@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String function;
	private String httpMethod;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getFunction() { return function; }
	public void setFunction(String function) { this.function = function; }
	public String getHttpMethod() { return httpMethod; }
	public void setHttpMethod(String httpMethod) { this.httpMethod = httpMethod; }
}

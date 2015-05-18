package models.smell;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import models.AbstractModel;

/**
 * Data model representing a {@link SmellGroup}.
 * 
 * @author cbi
 */
@Entity
public class SmellGroup extends AbstractModel {

	private String		name;
	private String 		description;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="group")
	private List<Smell> smells;
	
	//Getters & Setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public List<Smell> getSmells() { return smells; }
	public void setSmells(List<Smell> smells) { this.smells = smells; }
}

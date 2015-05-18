package models.task;

import javax.persistence.Entity;

import models.AbstractModel;

/**
 * Data model representing a {@link TaskPropertyType}.
 * 
 * @author cbi
 */
@Entity
public class TaskPropertyType extends AbstractModel {

	private String			name;	

	//Getters & Setters
	public String getNAme() { return name; }
	public void setName(String name) { this.name = name; }
}

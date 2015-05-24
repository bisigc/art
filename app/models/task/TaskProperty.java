package models.task;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import models.AbstractModel;

/**
 * Data model representing a {@link TaskProperty}.
 * 
 * @author cbi
 */
@Entity
public class TaskProperty extends AbstractModel {

	@ManyToOne(fetch = FetchType.EAGER)
	private TaskPropertyType	property;
	private String				value;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JsonBackReference(value="TaskTemplateTaskProperty")
	private TaskTemplate		tasktemplate;
	

	//Getters & Setters
	public TaskPropertyType getProperty() { return property; }
	public void setProperty(TaskPropertyType property) { this.property = property; }
	public String getValue() { return value; }
	public void setValue(String value) { this.value = value; }
	public TaskTemplate getTasktemplate() { return tasktemplate; }
	public void setTasktemplate(TaskTemplate tasktemplate) { this.tasktemplate = tasktemplate; }
}

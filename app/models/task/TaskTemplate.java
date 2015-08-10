package models.task;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import models.AbstractModel;

/**
 * Data model representing a {@link TaskTemplate}.
 * 
 * @author cbi
 */
@Entity
public class TaskTemplate extends AbstractModel {

	private String					name;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private TaskTemplate			parent;
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy="tasktemplate")
	@JsonManagedReference("TaskTemplateTaskProperty")
	private List<TaskProperty>		properties;
	
	/**
	 * Add a property to the list.
	 * 
	 * @param property Taskproperty to add to the childrens list
	 */
	public void addTaskProperty(TaskProperty property) {
		properties.add(property);
	}
	

	//Getters & Setters
	public TaskTemplate getParent() { return parent; }
	public void setParent(TaskTemplate parent) { this.parent = parent; };
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public List<TaskProperty> getProperties() { return properties; }
	public void setProperties(List<TaskProperty> properties) { this.properties = properties; }
}

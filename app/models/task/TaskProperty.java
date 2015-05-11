package models.task;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Data model representing a {@link TaskProperty}.
 * 
 * @author cbi
 */
@Entity
public class TaskProperty {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long				id;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private TaskPropertyType	property;
	private String				value;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private TaskTemplate		tasktemplate;
	

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public TaskPropertyType getProperty() { return property; }
	public void setProperty(TaskPropertyType property) { this.property = property; }
	public String getValue() { return value; }
	public void setValue(String value) { this.value = value; }
	public TaskTemplate getTasktemplate() { return tasktemplate; }
	public void setTasktemplate(TaskTemplate tasktemplate) { this.tasktemplate = tasktemplate; }
}

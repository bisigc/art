package models.task;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Data model representing a {@link TaskTemplate}.
 * 
 * @author cbi
 */
@Entity
public class TaskTemplate {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long					id;
	private String					name;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private TaskTemplate			parent;
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy="tasktemplate")
	private List<TaskProperty>		properties;
	
	/**
	 * Add a property to the list.
	 * 
	 * @param property
	 */
	public void addTaskProperty(TaskProperty property) {
		properties.add(property);
	}
	

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public TaskTemplate getParent() { return parent; }
	public void setParent(TaskTemplate parent) { this.parent = parent; };
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public List<TaskProperty> getProperties() { return properties; }
	public void setProperties(List<TaskProperty> properties) { this.properties = properties; }
}

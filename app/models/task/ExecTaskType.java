package models.task;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Data model representing a {@link ExecTaskType}.
 * 
 * @author cbi
 */
@Entity
public class ExecTaskType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long				id;
	@ManyToOne(cascade=CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="parent_id")
	private ExecTaskType		parent;
	private String				name;
	private String 				description;
	private Integer				ordering;
	@ElementCollection
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy="parent")
	private List<ExecTaskType>	subTasks;
	
	/**
	 * Add a subtask to the list.
	 * 
	 * @param task
	 */
	public void addSubTasks(ExecTaskType task) {
		task.setParent(this);
		subTasks.add(task);
	}
	
	/**
	 * Sets all parent ids of the subtasks recursively.
	 */
	public void setParents() {
		for (ExecTaskType execTaskType : subTasks) {
			execTaskType.setParent(this);
			execTaskType.setParents();
		}
	}

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	@JsonIgnore
	public ExecTaskType getParent() { return parent; }
	public void setParent(ExecTaskType parent) { this.parent = parent; };
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public Integer getOrdering() { return ordering; }
	public void setOrdering(Integer order) { this.ordering = order; }
	public List<ExecTaskType> getSubTasks() { return subTasks; }
	public void setSubTasks(List<ExecTaskType> subTasks) { this.subTasks = subTasks; }
}

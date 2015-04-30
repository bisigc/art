package models.smell;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Data model representing a {@link SmellGroup}.
 * 
 * @author cbi
 */
@Entity
public class SmellGroup {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long		id;
	private String		name;
	private String 		description;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="group")
	private List<Smell> smells;
	
	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public List<Smell> getSmells() { return smells; }
	public void setSmells(List<Smell> smells) { this.smells = smells; }
}

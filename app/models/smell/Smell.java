package models.smell;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.AbstractModel;
import models.status.ItemStatus;

/**
 * Data model representing a {@link Smell}.
 * 
 * @author cbi
 */
@Entity
public class Smell extends AbstractModel {

	private String name;
	@Column(length=5000)
	private String description;
	private String keywords;
	private Integer weight;
	@ManyToOne
	private SmellGroup group;
	private String tecdebtidx; // probability times (x) impact
	@ElementCollection
	@OneToMany(cascade=CascadeType.ALL, mappedBy="smell", orphanRemoval=true)
	private List<Question> questions;
	@Enumerated(EnumType.STRING)
	private ItemStatus status;
	private Timestamp modified;
	private Timestamp created;
	

	/**
	 * Sets the parent id for all the questions in the question list. 
	 */
	public void configQuestionParents() {
	    for (Question q : questions) {
			q.setSmell(this);
		}
	}

	//Getters & Setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getKeywords() { return keywords; }
	public void setKeywords(String keywords) { this.keywords = keywords; }
	public Integer getWeight() { return weight; }
	public void setWeight(Integer weight) { this.weight = weight; }
	public String getTecdebtidx() { return tecdebtidx; }
	public void setTecdebtidx(String tecdebtidx) { this.tecdebtidx = tecdebtidx; }
	public Timestamp getModified() { return modified; }
	public void setModified(Timestamp modified) { this.modified = modified; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
	//Custom getGroup to prevent Json Deserialize from Looping (due to Smell List in SmellGroup

	/**
	 * getGroup Returns only the id and the name of the group as a Map and
	 * not all the groups attributes.
	 * @return
	 */
	public Map<String, Object> getGroup() {
		Map<String, Object> group =  new HashMap<String, Object>();
		group.put("id", this.group.getId());
		group.put("name", this.group.getName());
		return group;
	}
	public void setGroup(SmellGroup group) { this.group = group; }
	public ItemStatus getStatus() { return status; }
	public void setStatus(ItemStatus status) { this.status = status; }
	public List<Question> getQuestions() { return questions; }
	public void setQuestions(List<Question> questions) { this.questions = questions; }
}

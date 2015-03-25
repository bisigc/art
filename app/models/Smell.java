package models;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import play.db.ebean.Model;

@Entity
public class Smell extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String keywords;
	private Double weight;
	@ManyToOne
	private Artprop group;
	private Double tecdebtidx; // probability times (x) impact
	private Timestamp modified;
	private Timestamp created;

	public static Finder<Long, Smell> find = new Finder<Long, Smell>(
			Long.class, Smell.class);

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public String getKeywords() { return keywords; }
	public void setKeywords(String keywords) { this.keywords = keywords; }
	public Double getWeight() { return weight; }
	public void setWeight(Double weight) { this.weight = weight; }
	public Artprop getGroup_id() { return group; }
	public void setGroup_id(Artprop group_id) { this.group = group_id; }
	public Double getTecdebtidx() { return tecdebtidx; }
	public void setTecdebtidx(Double tecdebtidx) { this.tecdebtidx = tecdebtidx; }
	public Timestamp getModified() { return modified; }
	public void setModified(Timestamp modified) { this.modified = modified; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
}

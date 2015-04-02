package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Property extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long	id;
	private String	categorie;
	private String	key;
	private String	name;
	private String	description;
	private Integer	orderidx;

	public static Finder<Long, Property> find = new Finder<Long, Property>(
			Long.class, Property.class);

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getCategorie() { return categorie; }
	public void setCategorie(String categorie) { this.categorie = categorie; }
	public String getKey() { return key; }
	public void setKey(String key) { this.key = key; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public Integer getOrderidx() { return orderidx; }
	public void setOrderidx(Integer orderidx) { this.orderidx = orderidx; }
}

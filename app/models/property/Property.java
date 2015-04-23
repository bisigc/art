package models.property;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Property {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long	id;
	private String	categorie;
	private String	attribute;
	private String	name;
	private String	description;
	private Integer	orderidx;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getCategorie() { return categorie; }
	public void setCategorie(String categorie) { this.categorie = categorie; }
	public String getAttribute() { return attribute; }
	public void setAttribute(String key) { this.attribute = key; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public Integer getOrderidx() { return orderidx; }
	public void setOrderidx(Integer orderidx) { this.orderidx = orderidx; }
}

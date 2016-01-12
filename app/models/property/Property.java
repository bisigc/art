package models.property;

import javax.persistence.Entity;

import models.AbstractModel;

/**
 * Data model representing a {@link Property}.
 * 
 * @author cbi
 */
@Entity
public class Property extends AbstractModel {

	private String	categorie;
	private String	attribute;
	private String	language;
	private String	name;
	private String	description;
	private Integer	orderidx;

	//Getters & Setters
	public String getCategorie() { return categorie; }
	public void setCategorie(String categorie) { this.categorie = categorie; }
	public String getAttribute() { return attribute; }
	public void setAttribute(String attribute) { this.attribute = attribute; }
	public String getLanguage() { return language; }
	public void setLanguage(String language) { this.language = language; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	public void setDescription(String description) { this.description = description; }
	public Integer getOrderidx() { return orderidx; }
	public void setOrderidx(Integer orderidx) { this.orderidx = orderidx; }
}

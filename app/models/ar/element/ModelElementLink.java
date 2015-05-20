package models.ar.element;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import models.AbstractModel;

@Entity
public class ModelElementLink extends AbstractModel {
	
	@Enumerated(EnumType.STRING)
	private ModelElementLinkType type;
	private String name;
	private String link;
	/*@ManyToMany
	private List<ArVersion> ar;*/
	
	public enum ModelElementLinkType {
		QASElementLink, 
		ContextElementLink,
		DecisionElementLink, 
		DesignElementLink,
		ComponentElementLink,
		ReferenceElementLink
	}

	// Getters and Setters
	public ModelElementLinkType getType() { return type; }
	public void setType(ModelElementLinkType type) { this.type = type; }	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getLink() { return link; }
	public void setLink(String link) { this.link = link; }
	/*public List<ArVersion> getAr() { return ar; }
	public void setAr(List<ArVersion> ar) { this.ar = ar; }*/
}

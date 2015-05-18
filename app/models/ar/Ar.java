package models.ar;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import models.AbstractModel;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Ar extends AbstractModel {
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="arhead", orphanRemoval=true, fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<ArVersion> versions;

	// Getters and Setters
	public List<ArVersion> getVersions() { return versions; }
	public void setVersions(List<ArVersion> versions) { this.versions = versions; }
}

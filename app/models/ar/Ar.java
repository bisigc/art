package models.ar;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Ar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="arhead", orphanRemoval=true, fetch=FetchType.EAGER)
	@JsonManagedReference
	private List<ArVersion> versions;

	// Getters and Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public List<ArVersion> getVersions() { return versions; }
	public void setVersions(List<ArVersion> versions) { this.versions = versions; }
}

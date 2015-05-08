package models.discussion;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.ar.ArVersion;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Data model representing a {@link Discussion}.
 * 
 * @author cbi
 */
@Entity
public class Discussion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private DiscussionType type;
	@JsonIgnore
	@ManyToOne
	private ArVersion ar;	
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="discussion")
	@JsonManagedReference(value="DiscussionComment")
	private List<Comment> comments;
	private Timestamp created;
	
	
	/**
	 * Enum with the available types of discussions.
	 * 
	 * @author cbi
	 */
	public enum DiscussionType {
	    COMMENTARY,
	    DISCUSSION
	}
	
	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public DiscussionType getType() { return type; }
	public void setType(DiscussionType type) { this.type = type; }
	public ArVersion getAr() { return ar; }
	public void setAr(ArVersion ar) { this.ar = ar; }
	public List<Comment> getComments() { return comments; }
	public void setComments(List<Comment> comments) { this.comments = comments; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
}

package models.ar;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import models.AbstractModel;
import models.ar.element.ModelElementLink;
import models.discussion.Discussion;
import models.smell.Smell;
import models.status.ItemStatus;
import models.user.User;

/**
 * Data model representing an Architectural Refactoring.
 * 
 * @author cbi
 */
@Entity
public class ArVersion extends AbstractModel {

	private String name;
	private String description;
	@ManyToOne
	private Ar arhead;
	@ManyToMany
	private List<Smell> smells;
	@ManyToMany
	private List<ModelElementLink> properties;
	
	@OneToOne(cascade=CascadeType.PERSIST, mappedBy="ar")
	private Discussion discussion;
	@OneToOne(cascade=CascadeType.PERSIST, mappedBy="ar")
	private Discussion commentary;
	@ManyToOne
	private User editor;
	@Enumerated(EnumType.STRING)
	private ItemStatus status;
	private Timestamp modified;
	private Timestamp created;

	//Getters & Setters
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
	// Return only the ID of the head AR to prevent loop in JSON.
	public Long getArhead() {
		return arhead.getId(); 
	}
	public void setArhead(Ar arhead) { this.arhead = arhead; }
	public List<Smell> getSmells() { return smells; }
	public void setSmells(List<Smell> smells) { this.smells = smells; }
	public void setDescription(String description) { this.description = description; }
	public User getUser() { return editor; }
	public void setUser(User editor) { this.editor = editor; }
	public Timestamp getModified() { return modified; }
	public void setModified(Timestamp modified) { this.modified = modified; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
	public Discussion getDiscussion() { return discussion; }
	public void setDiscussion(Discussion discussion) { this.discussion = discussion; }
	public Discussion getCommentary() { return commentary; }
	public void setCommentary(Discussion commentary) { this.commentary = commentary; }
	public User getEditor() { return editor; }
	public void setEditor(User editor) { this.editor = editor; }
	public ItemStatus getStatus() { return status; }
	public void setStatus(ItemStatus status) { this.status = status; }
}

package models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ArchitecturalRefactoring {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	@OneToOne(cascade=CascadeType.PERSIST, mappedBy="ar")
	private Discussion discussion;
	@OneToOne(cascade=CascadeType.PERSIST, mappedBy="ar")
	private Discussion commentary;
	@ManyToOne
	private User editor;
	@Enumerated(EnumType.STRING)
	private Status status;
	private Timestamp modified;
	private Timestamp created;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getDescription() { return description; }
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
	public Status getStatus() { return status; }
	public void setStatus(Status status) { this.status = status; }
}

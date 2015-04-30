package models.discussion;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import models.user.User;

/**
 * Data model representing a {@link Comment}.
 * 
 * @author cbi
 */
@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String comment;
	private Long likes;
	@ManyToOne
	private Discussion discussion;
	@ManyToOne
	private User user;
	private Timestamp modified;
	private Timestamp created;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
	public Long getLikes() { return likes; }
	public void setLikes(Long likes) { this.likes = likes; }
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	public Timestamp getModified() { return modified; }
	public void setModified(Timestamp modified) { this.modified = modified; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
}
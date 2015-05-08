package models.discussion;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.user.User;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@OneToMany(mappedBy="comment", orphanRemoval=true)
	private List<Likeing> likes;
	@ManyToOne
	@JsonBackReference(value="DiscussionComment")
	private Discussion discussion;
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	private Timestamp modified;
	private Timestamp created;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
	// Returns only the size of the likes list.
	public Integer getLikes() { return likes.size(); }
	public void setLikes(List<Likeing> likes) { this.likes = likes; }
	public Discussion getDiscussion() { return discussion; }
	public void setDiscussion(Discussion discussion) { this.discussion = discussion; }
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	public Timestamp getModified() { return modified; }
	public void setModified(Timestamp modified) { this.modified = modified; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
}

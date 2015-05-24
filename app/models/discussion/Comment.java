package models.discussion;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import models.AbstractModel;
import models.user.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Data model representing a {@link Comment}.
 * 
 * @author cbi
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment extends AbstractModel {

	@Column(length=1000)
	private String comment;
	@OneToMany(mappedBy="comment")
	@JsonIgnore
	private List<Likeing> likes;
	@ManyToOne
	@JsonBackReference(value="DiscussionComment")
	private Discussion discussion;
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	private Timestamp modified;
	private Timestamp created;

	public Integer getLikeCount() { return likes == null ? null : likes.size(); }
	
	//Getters & Setters
	public String getComment() { return comment; }
	public void setComment(String comment) { this.comment = comment; }
	public List<Likeing> getLikes() { return likes; }
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

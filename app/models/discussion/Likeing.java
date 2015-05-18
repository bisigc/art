package models.discussion;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import models.AbstractModel;
import models.user.User;

/**
 * Data model representing a {@link Likeing}.
 * 
 * @author cbi
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"comment_id", "user_id"}))
public class Likeing extends AbstractModel {

	@ManyToOne
	private Comment comment;
	@ManyToOne
	private User user;

	//Getters & Setters
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
	public Comment getComment() { return comment; }
	public void setComment(Comment comment) { this.comment = comment; }
}

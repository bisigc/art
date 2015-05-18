package models.smell;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import models.AbstractModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Data model representing a {@link Question} which is part of a {@link Smell}.
 * 
 * @author cbi
 */
@Entity
public class Question extends AbstractModel {

	private String question;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable=false)
	private Smell smell;

	//Getters & Setters
	public String getQuestion() { return question; }
	public void setQuestion(String question) { this.question = question; }
	public Smell getSmell() { return smell; }
	public void setSmell(Smell smell) { this.smell = smell; }
}

package models.smell;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {

	//private static final long serialVersionUID = -2657832215744368670L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String question;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(nullable=false)
	private Smell smell;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getQuestion() { return question; }
	public void setQuestion(String question) { this.question = question; }
	public Smell getSmell() { return smell; }
	public void setSmell(Smell smell) { this.smell = smell; }
}

package models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Abstract Model Class.
 *
 * @author cbi
 */
@MappedSuperclass
public abstract class AbstractModel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	// Getter and Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
}

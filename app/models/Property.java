package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import play.db.ebean.Model;

@Entity
public class Artprop extends Model {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String categorie;
	private String name;

	public static Finder<Long, Artprop> find = new Finder<Long, Artprop>(
			Long.class, Artprop.class);

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getCategorie() { return categorie; }
	public void setCategorie(String categorie) { this.categorie = categorie; }
}

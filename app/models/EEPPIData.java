package models;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;

@Entity
public class EEPPIData extends Model {

	@Id
	private Long id;
	private String from_service;
	private String json_data;
	private Timestamp created;

	public static Finder<Long, EEPPIData> find = new Finder<Long, EEPPIData>(
			Long.class, EEPPIData.class);

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getFrom_service() { return from_service; }
	public void setFrom_service(String from_service) { this.from_service = from_service; }
	public String getJson_data() { return json_data; }
	public void setJson_data(String json_data) { this.json_data = json_data; }
	public Timestamp getCreated() { return created; }
	public void setCreated(Timestamp created) { this.created = created; }
}

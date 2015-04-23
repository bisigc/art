package models.menu;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Menuitem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long			id;
	@ManyToOne(fetch = FetchType.LAZY)
	private Menuitem		menuitem;
	private String			name;
	private String 			fullname;
	private String			tooltip;
	private String			image;
	private String 			type;
	private String			url;
	private String  		pos;
	private Integer			ordering;
	@OneToMany(cascade=CascadeType.PERSIST, mappedBy="menuitem")
	private List<Menuitem>	subItems;

	//Getters & Setters
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getFullname() { return fullname; }
	public void setFullname(String fullname) { this.fullname = fullname; }
	public String getTooltip() { return tooltip; }
	public void setTooltip(String tooltip) { this.tooltip = tooltip; }
	public String getImage() { return image; }
	public void setImage(String image) { this.image = image; }
	public String getType() { return type; }
	public void setType(String type) { this.type = type; }
	public String getUrl() { return url; }
	public void setUrl(String url) { this.url = url; }
	public String getPos() { return pos; }
	public void setPos(String pos) { this.pos = pos; }
	public Integer getOrdering() { return ordering; }
	public void setOrdering(Integer order) { this.ordering = order; }
	public List<Menuitem> getSubItems() { return subItems; }
	public void setSubItems(List<Menuitem> subItems) { this.subItems = subItems; }
}

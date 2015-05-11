package models.statistic;


/**
 * Data model representing a {@link StatisticValue}.
 * 
 * @author cbi
 */
public class StatisticValue {

	private String name;
	private Integer count;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public Integer getCount() { return count; }
	public void setCount(Integer count) { this.count = count; }
}

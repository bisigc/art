package controllers.statistic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import models.statistic.StatisticValue;
import play.cache.Cached;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import com.google.inject.Singleton;

/**
 * Extends the general class {@link play.mvc.Controller}. Contains one method which
 * returns statistics values all values about the ART as a JsonNode.
 * Is annotated with {@link com.google.inject.Singleton}, which makes sure
 * the DI framework creates only one instance of the class.
 * 
 * @author cbi
 */
@Singleton
public class StatisticController extends Controller {
	
	/**
	 * Returns statistical values about the ART as a JsonNode.
	 * 
	 * @return
	 */
	@Transactional(readOnly=true)
	@Cached(key="ARTStats")
	public Result get() {
		List<StatisticValue> list = new ArrayList<StatisticValue>();
		
		addStat(list, "Architectural Refactorings", "select count(a) from Ar a");
		addStat(list, "Versions of Architectural Refactorings", "select count(a) from ArVersion a");
		addStat(list, "Smells", "select count(a) from Smell a");
		//addStat(list, "Tasks", "select count(a) from Task a");
		addStat(list, "Registered users", "select count(a) from User a");
		addStat(list, "User comments", "select count(a) from Comment a");
		
		return ok(Json.toJson(list));
	}
	
	private void addStat(List<StatisticValue> list, String name, String queryString) {
		TypedQuery<Long> query =  JPA.em().createQuery(queryString, Long.class);
		Long count = query.getSingleResult();
		StatisticValue stat = new StatisticValue();
		stat.setName(name);
		stat.setCount(count.intValue());
		list.add(stat);
	}
	
}

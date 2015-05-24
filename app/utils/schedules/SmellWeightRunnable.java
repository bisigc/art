package utils.schedules;

import java.util.List;

import javax.persistence.TypedQuery;

import models.smell.Smell;
import play.Logger;
import play.db.jpa.JPA;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import dao.GenericDAO;

/**
 * Class implements runnable.
 * The runnable selects the count of references of each Smell
 * and updates the weight attribute for each Smell with the count.
 * 
 * @author cbi
 */
public class SmellWeightRunnable implements Runnable {
	
	private GenericDAO<Smell, Long> dao;
	
	private String countSelect = "Select count(a.id) from ArVersion a join a.smells s "
					+ "where s.id = :smellid "
					+ "and a.status = 'published' "
					+ "and a.created = "
					+ "(select max(c.created) from ArVersion c join c.smells t "
							+ "where t.id = :smellid "
							+ "and a.arhead.id = c.arhead.id "
							+ "and c.status = 'published')";

	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is
	 * "@Named("SmellDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public SmellWeightRunnable(@Named("SmellDAO") GenericDAO<Smell, Long> dao) {
		this.dao = dao;
	}
	
	
	@Override
	public void run() {
		JPA.withTransaction(new play.libs.F.Callback0() {
			@Override
			public void invoke() throws Throwable {
				recalculateSmellWeights();
			}
		});		
	}
	
	/**
	 * Recalculates the weight of all Smells found.
	 */
	private void recalculateSmellWeights() {
		try {
			TypedQuery<Long> query = JPA.em().createQuery(countSelect, Long.class);
			List<Smell> smells = dao.getAll();
			Long count;
			for (Smell smell : smells) {
				query.setParameter("smellid", smell.getId());
				count = query.getSingleResult();
				smell.setWeight(count.intValue());
			}
			
			JPA.em().flush();
			Logger.info("Scheduled job for recalculating the Smell weights has finished successfully.");
		} catch (Exception e) {
			Logger.error("Failed to update Smell weights.", e);
		}
	}

}

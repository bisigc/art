package controllers.task;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.task.TaskProperty;
import models.task.TaskPropertyType;
import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link TaskProperty} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class TaskPropertyController extends AbstractCRUDController<TaskPropertyType, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("TaskPropertyDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public TaskPropertyController(@Named("TaskPropertyDAO") GenericDAO<TaskPropertyType, Long> dao) {
		super(dao);
	}

}

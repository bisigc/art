package controllers.task;

import models.task.TaskProperty;
import models.task.TaskPropertyType;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link TaskProperty} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class TaskPropertyController extends AbstractCRUDController<TaskPropertyType, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("TaskPropertyDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public TaskPropertyController(@Named("TaskPropertyDAO") GenericDAO<TaskPropertyType, Long> dao) {
		super(dao);
	}

}

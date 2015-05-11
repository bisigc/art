package controllers.task;

import models.task.TaskProperty;

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
public class TaskPropertyController extends AbstractCRUDController<TaskProperty, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("TaskPropertyDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public TaskPropertyController(@Named("TaskPropertyDAO") GenericDAO<TaskProperty, Long> dao) {
		super(dao);
	}

}

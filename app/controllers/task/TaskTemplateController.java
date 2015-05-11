package controllers.task;

import models.task.TaskTemplate;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link TaskTemplate} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
public class TaskTemplateController extends AbstractCRUDController<TaskTemplate, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("TaskTemplateDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public TaskTemplateController(@Named("TaskTemplateDAO") GenericDAO<TaskTemplate, Long> dao) {
		super(dao);
	}

}

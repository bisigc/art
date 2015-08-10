package controllers.task;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import models.task.TaskTemplate;
import controllers.AbstractCRUDController;
import dao.GenericDAO;

/**
 * Concrete implementation of an {@link AbstractCRUDController} to retrieve and manipulate
 * {@link TaskTemplate} Objects via RESTful HTTP Request.
 * 
 * @author cbi
 */
@Singleton
public class TaskTemplateController extends AbstractCRUDController<TaskTemplate, Long> {
	
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("TaskTemplateDAO")".
	 * 
	 * @param dao GenericDAO
	 */
	@Inject
	public TaskTemplateController(@Named("TaskTemplateDAO") GenericDAO<TaskTemplate, Long> dao) {
		super(dao);
	}

}

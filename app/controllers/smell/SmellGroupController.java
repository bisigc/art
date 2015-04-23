package controllers.smell;

import models.smell.SmellGroup;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class SmellGroupController extends AbstractCRUDController<SmellGroup, Long> {
	
	@Inject
	public SmellGroupController(@Named("SmellGroupDAO") GenericDAO<SmellGroup, Long> dao) {
		super(dao);
	}

}

package controllers.ar;

import models.ar.ArchitecturalRefactoring;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import controllers.AbstractCRUDController;
import dao.GenericDAO;

public class ARController extends AbstractCRUDController<ArchitecturalRefactoring, Long> {
	
	@Inject
	public ARController(@Named("ArDAO") GenericDAO<ArchitecturalRefactoring, Long> dao) {
		super(dao);
	}

}

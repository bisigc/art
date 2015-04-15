package utils.injectors;

import com.google.inject.AbstractModule;

import dao.GenericDAO;
import dao.MenuitemDAO;

public class MainInjector extends AbstractModule {

	@Override
	protected void configure() {
		bind(GenericDAO.class).to(MenuitemDAO.class);
	}
}

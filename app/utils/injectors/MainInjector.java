package utils.injectors;

import models.ExecTaskType;
import models.Menuitem;
import models.Property;
import models.Role;
import models.Smell;
import models.SmellGroup;
import models.User;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import dao.GenericDAO;
import dao.GenericDAOImpl;

public class MainInjector extends AbstractModule {

	@Override
	protected void configure() {
		//bind(GenericDAO.class).to(MenuitemDAO.class);
		//bind(new TypeLiteral<GenericDAO<Menuitem, Long>>(){}).to(new TypeLiteral<GenericDAOImpl<Menuitem, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Menuitem, Long>>(){}).annotatedWith(Names.named("MenuitemDAO")).to(new TypeLiteral<GenericDAOImpl<Menuitem, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Property, Long>>(){}).annotatedWith(Names.named("PropertyDAO")).to(new TypeLiteral<GenericDAOImpl<Property, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Smell, Long>>(){}).annotatedWith(Names.named("SmellDAO")).to(new TypeLiteral<GenericDAOImpl<Smell, Long>>(){});
		bind(new TypeLiteral<GenericDAO<SmellGroup, Long>>(){}).annotatedWith(Names.named("SmellGroupDAO")).to(new TypeLiteral<GenericDAOImpl<SmellGroup, Long>>(){});
		bind(new TypeLiteral<GenericDAO<ExecTaskType, Long>>(){}).annotatedWith(Names.named("ExecTaskTypeDAO")).to(new TypeLiteral<GenericDAOImpl<ExecTaskType, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Role, Long>>(){}).annotatedWith(Names.named("RoleDAO")).to(new TypeLiteral<GenericDAOImpl<Role, Long>>(){});
		bind(new TypeLiteral<GenericDAO<User, Long>>(){}).annotatedWith(Names.named("UserDAO")).to(new TypeLiteral<GenericDAOImpl<User, Long>>(){});
	}
}

package utils.injectors;

import models.ar.Ar;
import models.ar.ArVersion;
import models.discussion.Comment;
import models.discussion.Discussion;
import models.discussion.Likeing;
import models.menu.Menuitem;
import models.property.Property;
import models.smell.Smell;
import models.smell.SmellGroup;
import models.task.ExecTaskType;
import models.user.Role;
import models.user.User;
import utils.security.RoleChecker;
import utils.security.RoleCheckerImpl;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

import dao.GenericDAO;
import dao.GenericDAOImpl;

/**
 * Injector Modul class, contains the dependency injecting rules for the ART application
 * used by the DI framework "Dice" from Google. 
 * 
 * @author cbi
 */
public class MainInjector extends AbstractModule {

	@Override
	protected void configure() {
		//bind(GenericDAO.class).to(MenuitemDAO.class);
		//bind(new TypeLiteral<GenericDAO<Menuitem, Long>>(){}).to(new TypeLiteral<GenericDAOImpl<Menuitem, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Ar, Long>>(){}).annotatedWith(Names.named("ArDAO")).to(new TypeLiteral<GenericDAOImpl<Ar, Long>>(){});
		bind(new TypeLiteral<GenericDAO<ArVersion, Long>>(){}).annotatedWith(Names.named("ArVersionDAO")).to(new TypeLiteral<GenericDAOImpl<ArVersion, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Menuitem, Long>>(){}).annotatedWith(Names.named("MenuitemDAO")).to(new TypeLiteral<GenericDAOImpl<Menuitem, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Property, Long>>(){}).annotatedWith(Names.named("PropertyDAO")).to(new TypeLiteral<GenericDAOImpl<Property, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Smell, Long>>(){}).annotatedWith(Names.named("SmellDAO")).to(new TypeLiteral<GenericDAOImpl<Smell, Long>>(){});
		bind(new TypeLiteral<GenericDAO<SmellGroup, Long>>(){}).annotatedWith(Names.named("SmellGroupDAO")).to(new TypeLiteral<GenericDAOImpl<SmellGroup, Long>>(){});
		bind(new TypeLiteral<GenericDAO<ExecTaskType, Long>>(){}).annotatedWith(Names.named("ExecTaskTypeDAO")).to(new TypeLiteral<GenericDAOImpl<ExecTaskType, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Role, Long>>(){}).annotatedWith(Names.named("RoleDAO")).to(new TypeLiteral<GenericDAOImpl<Role, Long>>(){});
		bind(new TypeLiteral<GenericDAO<User, Long>>(){}).annotatedWith(Names.named("UserDAO")).to(new TypeLiteral<GenericDAOImpl<User, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Discussion, Long>>(){}).annotatedWith(Names.named("DiscussionDAO")).to(new TypeLiteral<GenericDAOImpl<Discussion, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Comment, Long>>(){}).annotatedWith(Names.named("CommentDAO")).to(new TypeLiteral<GenericDAOImpl<Comment, Long>>(){});
		bind(new TypeLiteral<GenericDAO<Likeing, Long>>(){}).annotatedWith(Names.named("LikeingDAO")).to(new TypeLiteral<GenericDAOImpl<Likeing, Long>>(){});
		bind(new TypeLiteral<RoleChecker>(){}).annotatedWith(Names.named("RoleChecker")).to(new TypeLiteral<RoleCheckerImpl>(){});
		//.in(Scopes.SINGLETON);
	}
}

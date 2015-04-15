import java.util.HashMap;
import java.util.Map;

import play.GlobalSettings;
import utils.injectors.MainInjector;

import com.google.inject.Guice;
import com.google.inject.Injector;

import controllers.Application;
import controllers.menu.MenuController;
import controllers.property.PropertyController;
import controllers.smell.SmellController;
import controllers.status.StatusController;
import controllers.task.ExecTaskTypeController;
import controllers.user.UserController;
import dao.ExecTaskTypeDAO;
import dao.MenuitemDAO;
import dao.PropertyDAO;
import dao.SmellDAO;
import dao.UserDAO;


public class Global extends GlobalSettings {
	
	@SuppressWarnings("rawtypes")
	private final Map<Class, Object> CONTROLLERS = new HashMap<>();
	
	private static final Injector INJECTOR = createInjector();
	
	@Override
	public void onStart(play.Application app) {
		initControllers();
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public <A> A getControllerInstance(Class<A> controllerClass) throws Exception {
		A a;
		if(CONTROLLERS.containsKey(controllerClass)) {
			a = (A) CONTROLLERS.get(controllerClass);
		} else {
		 a = INJECTOR.getInstance(controllerClass);
		}
		return a;
	}
	
	private void initControllers() {
		CONTROLLERS.put(MenuController.class, new MenuController(new MenuitemDAO()));
		CONTROLLERS.put(PropertyController.class, new PropertyController(new PropertyDAO()));
		CONTROLLERS.put(SmellController.class, new SmellController(new SmellDAO()));
		CONTROLLERS.put(StatusController.class, new StatusController());
		CONTROLLERS.put(ExecTaskTypeController.class, new ExecTaskTypeController(new ExecTaskTypeDAO()));
		CONTROLLERS.put(UserController.class, new UserController(new UserDAO()));
		CONTROLLERS.put(Application.class, new Application());
	}
	
	private static Injector createInjector() {
		return Guice.createInjector(new MainInjector());
	}

}

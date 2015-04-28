package utils;
import play.GlobalSettings;
import utils.injectors.MainInjector;

import com.google.inject.Guice;
import com.google.inject.Injector;


public class Global extends GlobalSettings {

	private static Injector INJECTOR = createInjector();

	@Override
	public <A> A getControllerInstance(Class<A> controllerClass)
			throws Exception {
		A a = INJECTOR.getInstance(controllerClass);
		return a;
	}

	private static Injector createInjector() {
		return Guice.createInjector(new MainInjector());
	}

	public static Injector getInjector() {
		return INJECTOR;
	}
}

package utils;

import java.lang.reflect.Method;

import play.Application;
import play.Configuration;
import play.GlobalSettings;
import play.Play;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;
import utils.injectors.MainInjector;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Global Settings for the ART application.
 * Sets up the DI framework configuration for Controllers and DAOs used in the ART application.
 * The overwritten Method onRequest resets the session time (in case of a logged in user session),
 * to prevent session timeout.
 * 
 * @author cbi
 */
public class Global extends GlobalSettings {

	private static Injector INJECTOR = createInjector();
	
	private Configuration conf;
	private long timeout;

	/**
	 * Returns instances of the requested controller classes. Using
	 * GUICE DI framework injector.
	 * 
	 * @see play.GlobalSettings#getControllerInstance(java.lang.Class)
	 */
	@Override
	public <A> A getControllerInstance(Class<A> controllerClass)
			throws Exception {
		A a = INJECTOR.getInstance(controllerClass);
		return a;
	}

	/**
	 * Creates an instance of the GUICE Dependency Injector. With the
	 * configuration module {@link MainInjector}.
	 * 
	 * @return
	 */
	private static Injector createInjector() {
		return Guice.createInjector(new MainInjector());
	}

	/**
	 * Returns the instance of the GUICE injector object.
	 * 
	 * @return
	 */
	public static Injector getInjector() {
		return INJECTOR;
	}
	
	

	/**
	 * Overwritten onStart method, loads default session timeout time.
	 * 
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	@Override
	public void onStart(Application arg0) {
		conf = Play.application().configuration();
		timeout = Long.parseLong(conf.getString("default.sessiontimeout")) * 60 * 1000;
		super.onStart(arg0);
	}

	/**
	 * Overwritten ethod onRequest resets the session time (in case of a logged in user session),
	 * to prevent session timeout.
	 * 
	 * @see play.GlobalSettings#onRequest(play.mvc.Http.Request, java.lang.reflect.Method)
	 */
	@Override
	public Action.Simple onRequest(play.mvc.Http.Request request, Method method) {

		return new Action.Simple() {
			@Override
			public Promise<Result> call(Context ctx) throws Throwable {
				if(ctx.session().get("email") != null) {
					long time = Long.parseLong(ctx.session().get("time"));
					long currenttime = System.currentTimeMillis();
					long sessiontime = currenttime - time;
					
					if(sessiontime > timeout) {
						// Nothing has to be done here, timeout is handled by the SessionAuhtAction
					} else {
						ctx.session().put("time", Long.toString(currenttime));
					}
				}
				return delegate.call(ctx);
			}
		};
	}

}

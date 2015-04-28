package utils;

import java.lang.reflect.Method;

import play.Application;
import play.Configuration;
import play.GlobalSettings;
import play.Play;
import play.libs.F;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;
import play.mvc.Results;
import utils.injectors.MainInjector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Global extends GlobalSettings {

	private static Injector INJECTOR = createInjector();
	
	private Configuration conf;
	private long timeout;

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
	
	

	@Override
	public void onStart(Application arg0) {
		conf = Play.application().configuration();
		timeout = Long.parseLong(conf.getString("default.sessiontimeout")) * 60 * 1000;
		super.onStart(arg0);
	}

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

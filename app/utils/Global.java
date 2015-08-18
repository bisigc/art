package utils;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import play.Application;
import play.Configuration;
import play.GlobalSettings;
import play.Play;
import play.libs.Akka;
import play.libs.F.Promise;
import play.mvc.Action;
import play.mvc.Http.Context;
import play.mvc.Result;
import scala.concurrent.duration.Duration;
import utils.schedules.SmellWeightRunnable;
import akka.actor.Cancellable;

/**
 * Global Settings for the ART application. Sets up the DI framework
 * configuration for Controllers and DAOs used in the ART application. The
 * overwritten Method onRequest resets the session time (in case of a logged in
 * user session), to prevent session timeout.
 * 
 * @author cbi
 */
public class Global extends GlobalSettings {

	private Configuration conf;
	private long timeout;
	private Cancellable smellWeightActor;

	/**
	 * Overwritten onStart method, loads default session timeout time.
	 * And starts batch job for periodical Smell Weight recalculation.
	 * 
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	@Override
	public void onStart(Application arg0) {
		conf = Play.application().configuration();
		timeout = Long.parseLong(conf.getString("default.sessiontimeout")) * 60 * 1000;
		Boolean smellWeightCalcEnabled =  conf.getBoolean("smellweightrecalc.enabled");
		if(smellWeightCalcEnabled) {
			Long interval = conf.getLong("smellweightrecalc.interval");
			Runnable run = Play.application().injector().instanceOf(SmellWeightRunnable.class);
			smellWeightActor = Akka.system().scheduler().schedule(
					Duration.create(0, TimeUnit.MILLISECONDS),
					Duration.create(interval, TimeUnit.MINUTES),
					run,
					Akka.system().dispatcher());
		}
		super.onStart(arg0);
	}

	/**
	 * Overwritten inStop method. Cancels the SmellWeight Task and 
	 * shuts down the Akka system before quitting the application.
	 * 
	 * @see play.GlobalSettings#onStop(play.Application)
	 */
	@Override
	public void onStop(Application arg0) {
		smellWeightActor.cancel();
		Akka.system().shutdown();
		super.onStop(arg0);
	}

	/**
	 * Overwritten ethod onRequest resets the session time (in case of a logged
	 * in user session), to prevent session timeout.
	 * 
	 * @see play.GlobalSettings#onRequest(play.mvc.Http.Request,
	 *      java.lang.reflect.Method)
	 */
	@Override
	public Action.Simple onRequest(play.mvc.Http.Request request, Method method) {

		return new Action.Simple() {
			@Override
			public Promise<Result> call(Context ctx) throws Throwable {
				if (ctx.session().get("email") != null) {
					long time = Long.parseLong(ctx.session().get("time"));
					long currenttime = System.currentTimeMillis();
					long sessiontime = currenttime - time;

					if (sessiontime > timeout) {
						// Nothing has to be done here, timeout is handled by
						// the SessionAuhtAction
					} else {
						ctx.session().put("time", Long.toString(currenttime));
					}
				}
				return delegate.call(ctx);
			}
		};
	}

}

package utils.actions;

import play.Configuration;
import play.Logger;
import play.Play;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import utils.security.RoleChecker;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class SessionAuthAction extends Action.Simple {
	
	private static Configuration CONF = Play.application().configuration();
	private static long timeout = Long.parseLong(CONF.getString("default.sessiontimeout")) * 60 * 1000;
	private RoleChecker roleChecker;
	
	@Inject
	public SessionAuthAction(@Named("RoleChecker") RoleChecker rolechecker) {
		this.roleChecker = rolechecker;
	}

	@Override
	public F.Promise<Result> call(Http.Context ctx) throws Throwable {
		String email = ctx.session().get("email");
		
		if(email == null) {			
			Result unauthorized = Results.unauthorized("unauthorized");
			return F.Promise.pure(unauthorized);
		} else {
			
			long time = Long.parseLong(ctx.session().get("time"));
			long currenttime = System.currentTimeMillis();
			long sessiontime = currenttime - time;
			
			if(sessiontime > timeout) {
				ctx.session().clear();
				Result unauthorized = Results.unauthorized("Session timeout");
				return F.Promise.pure(unauthorized);
			} else {
				// ctx.session().put("time", Long.toString(currenttime));
				String httpMethod = ctx._requestHeader().method();
				String appContext = CONF.getString("application.context");
				String function = ctx._requestHeader().path().split(appContext)[1].split("/")[0];
				String userrole = ctx.session().get("role");
				
				if(Logger.isDebugEnabled()) {
					Logger.debug("httpMethod: " + httpMethod);
					Logger.debug("appContext: " + appContext);
					Logger.debug("function:   " + function);
					Logger.debug("userrole:   " + userrole);
				}
				
				if(roleChecker.isAllowed(userrole, function, httpMethod)) {
					return delegate.call(ctx);					
				} else {
					Result unauthorized = Results.unauthorized("unauthorized");
					return F.Promise.pure(unauthorized);					
				}
				
			}
		
		}
		
	}

}

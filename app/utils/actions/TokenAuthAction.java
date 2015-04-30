package utils.actions;

import java.util.List;

import javax.persistence.TypedQuery;

import models.user.User;
import play.db.jpa.JPA;
import play.libs.F;
import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import dao.GenericDAO;

/**
 * HTTP Request Action. Verifying the request based on token 
 * authentication. And verifying the users permissions.
 * 
 * @author cbi
 */
public class TokenAuthAction extends Action.Simple {

	protected GenericDAO<User, Long> dao;
    
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("UserDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public TokenAuthAction(@Named("UserDAO") GenericDAO<User, Long> dao) {
		this.dao = dao;
	} 

	@Override
	public F.Promise<Result> call(Http.Context ctx) throws Throwable {
		String token = getTokenFromHeader(ctx);
		if (token != null) {
			TypedQuery<User> query = JPA.em().createQuery(
					"select a from User a where a.authToken = :toke", User.class);
			query.setParameter("token", token);
			List<User> data = dao.find(query);

			User user = data.get(0);
			if (user != null) {
				ctx.request().setUsername(user.getEmail());
				return delegate.call(ctx);
			}
		}
		Result unauthorized = Results.unauthorized("unauthorized");
		return F.Promise.pure(unauthorized);
	}

	/**
	 * Extracts the authentication token from the HTTP header. 
	 * 
	 * @param ctx
	 * @return
	 */
	private String getTokenFromHeader(Http.Context ctx) {
		String[] authTokenHeaderValues = ctx.request().headers()
				.get("X-AUTH-TOKEN");
		if ((authTokenHeaderValues != null)
				&& (authTokenHeaderValues.length == 1)
				&& (authTokenHeaderValues[0] != null)) {
			return authTokenHeaderValues[0];
		}
		return null;
	}

}

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

public class TokenAuthAction extends Action.Simple {

	protected GenericDAO<User, Long> dao;
    
	@Inject
	public TokenAuthAction(@Named("UserDAO") GenericDAO<User, Long> dao) {
		this.dao = dao;
	} 

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

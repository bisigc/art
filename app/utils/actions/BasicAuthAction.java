package utils.actions;

import java.util.Base64;
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
 * HTTP Request Action. Verifying the request based on HTTP basic
 * authentication. And verifying the users permissions.
 * 
 * @author cbi
 */
public class BasicAuthAction extends Action.Simple {

    private static final String AUTHORIZATION = "authorization";
    private static final String WWW_AUTHENTICATE = "WWW-Authenticate";
    private static final String REALM = "Basic realm=\"Your Realm Here\"";
    
	protected GenericDAO<User, Long> dao;
    
	/**
	 * Constructor receives a {@link GenericDAO}. DI framework hook is "@Named("UserDAO")".
	 * 
	 * @param dao
	 */
	@Inject
	public BasicAuthAction(@Named("UserDAO") GenericDAO<User, Long> dao) {
		this.dao = dao;
	} 

    /* (non-Javadoc)
     * @see play.mvc.Action#call(play.mvc.Http.Context)
     */
    @Override
    public F.Promise<Result> call(Http.Context context) throws Throwable {

        String authHeader = context.request().getHeader(AUTHORIZATION);
        if (authHeader == null) {
            context.response().setHeader(WWW_AUTHENTICATE, REALM);
			Result unauthorized = Results.unauthorized("unauthorized");
			return F.Promise.pure(unauthorized);
        }

        String auth = authHeader.substring(6);
        byte[] decodedAuth = Base64.getDecoder().decode(auth);
        String[] credString = new String(decodedAuth, "UTF-8").split(":");

        if (credString == null || credString.length != 2) {
			Result unauthorized = Results.unauthorized("unauthorized");
			return F.Promise.pure(unauthorized);
        }

        String username = credString[0];
        String password = credString[1];        
        
		TypedQuery<User> query = JPA.em().createQuery(
				"select a from User a where a.email = :email", User.class);
		query.setParameter("email", username);
		List<User> data = dao.find(query);

        if(data == null) {
			Result unauthorized = Results.unauthorized("unauthorized");
			return F.Promise.pure(unauthorized);
        } else {
            User authUser = data.get(0);
            if(authUser.getDigest().isPasswordValid(password)) {
            	return delegate.call(context);
            } else { 
    			Result unauthorized = Results.unauthorized("unauthorized");
    			return F.Promise.pure(unauthorized);
            }
        }
    }
}
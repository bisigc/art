package utils.restconfig;

/**
 * Interface providing the values necessary to work with a REST service using a {@link dao.GenericDAORestImpl}. 
 * 
 * @author cbi
 */
public interface RestServiceConfig {
	
	/**
	 * Provides the url to the REST service.
	 * 
	 * @return access url
	 */
	String getUrl();
	
	/**
	 * Provides the username for the REST service call.
	 * 
	 * @return access username
	 */
	String getUser();
	
	/**
	 * Provides the password for the REST service call.
	 * 
	 * @return acccess password
	 */
	String getPassword();
	
	/**
	 * Provides the timeout value to be used for the REST service call.
	 * 
	 * @return Integer timeout value
	 */
	Integer getTimeout();
	
}

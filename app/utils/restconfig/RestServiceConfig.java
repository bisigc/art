package utils.restconfig;

/**
 * Interface providing the values necessary to work with a REST service using a {@link GenericDAORestImpl}. 
 * 
 * @author cbi
 */
public interface RestServiceConfig {
	
	/**
	 * Provides the url to the REST service.
	 * 
	 * @return
	 */
	String getUrl();
	
	/**
	 * Provides the username for the REST service call.
	 * 
	 * @return
	 */
	String getUser();
	
	/**
	 * Provides the password for the REST service call.
	 * 
	 * @return
	 */
	String getPassword();
	
	/**
	 * Provides the timeout value to be used for the REST service call.
	 * 
	 * @return
	 */
	Integer getTimeout();
	
}

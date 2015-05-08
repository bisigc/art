package utils.security;


/**
 * Interface representing a RoleChecker. Containing method isAllowed validates
 * a provided Roles permission based on a HTTP function and the HTTP method.
 * 
 * @author cbi
 */
public interface RoleChecker {

	/**
	 * Validates a provided Roles permission based on a HTTP function and the HTTP method.
	 * 
	 * @param the Role of the current user
	 * @param function the called HTTP function 
	 * @param httpMethod the used HTTP method
	 * @return
	 */
	boolean isAllowed(String role, String function, String httpMethod);
}

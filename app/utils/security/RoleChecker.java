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
	 * @param role the Role of the current user
	 * @param function the called HTTP function 
	 * @param httpMethod the used HTTP method
	 * @return if role is allowed to call the httpMethod on the function
	 */
	boolean isAllowed(String role, String function, String httpMethod);
}

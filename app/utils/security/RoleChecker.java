package utils.security;


public interface RoleChecker {

	boolean isAllowed(String role, String function, String httpMethod);
}

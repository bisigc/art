package utils.exceptions;


/**
 * Session can be thrown if the session has timed out.
 * 
 * @author cbi
 */
public class SessionTimeoutException extends Exception {

	private static final long serialVersionUID = 8661033600432011292L;

	public SessionTimeoutException(String msg) {
		super(msg);
	}

}

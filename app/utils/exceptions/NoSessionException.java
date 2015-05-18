package utils.exceptions;

/**
 * Exception can be thrown in case of no session being available.
 * 
 * @author cbi
 */
public class NoSessionException extends Exception {

	private static final long serialVersionUID = -5491290198625998807L;
	
	public NoSessionException(String msg) {
		super(msg);
	}

}

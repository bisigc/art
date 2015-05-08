package utils.exceptions;

/**
 * Thrown in case of any unauthorized action.
 * 
 * @author cbi
 */
public class UnauthorizedException extends Exception {
	
	private static final long serialVersionUID = 6434557053420005811L;

	public UnauthorizedException(String msg) {
		super(msg);
	}

}

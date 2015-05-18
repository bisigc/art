package utils.exceptions;

/**
 * Thrown if a conflict occurs.
 * 
 * @author cbi
 */
public class ConflictException extends Exception {

	private static final long serialVersionUID = 2761172903380830683L;

	public ConflictException(String msg) {
		super(msg);
	}

}

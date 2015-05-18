package utils.exceptions;

/**
 * Thrown if an item could not be found.
 * 
 * @author cbi
 */
public class ItemNotFoundException extends Exception {

	private static final long serialVersionUID = -4128725195963073296L;

	public ItemNotFoundException(String msg) {
		super(msg);
	}

}

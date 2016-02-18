


import play.Application;
import play.GlobalSettings;

/**
 * Global Test Settings for the ART application.
 * 
 * @author cbi
 */
public class GlobalUnitTest extends GlobalSettings {
	
	/**
	 * Overwritten onStart method.
	 * 
	 * @see play.GlobalSettings#onStart(play.Application)
	 */
	@Override
	public void onStart(Application arg0) {
		super.onStart(arg0);
	}

	/**
	 * Overwritten inStop method.
	 * 
	 * @see play.GlobalSettings#onStop(play.Application)
	 */
	@Override
	public void onStop(Application arg0) {
		super.onStop(arg0);
	}

}

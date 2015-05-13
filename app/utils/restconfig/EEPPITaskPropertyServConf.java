package utils.restconfig;

import play.Play;

/**
 * Implementation of a {@link RestServiceConfig} to use the EEPPI Task Property Service.
 * Loads the configuration from the play application configuration file.
 *
 * @author cbi
 */
public class EEPPITaskPropertyServConf implements RestServiceConfig {

	@Override
	public String getUrl() {
		return Play.application().configuration().getString("service.eppi.taskproperty.url");
	}

	@Override
	public String getUser() {
		return Play.application().configuration().getString("service.eppi.user");
	}

	@Override
	public String getPassword() {
		return Play.application().configuration().getString("service.eppi.password");
	}

	@Override
	public Integer getTimeout() {
		return Integer.parseInt(Play.application().configuration().getString("service.eppi.timeout"));
	}

}

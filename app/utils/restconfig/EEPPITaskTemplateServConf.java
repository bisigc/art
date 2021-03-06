package utils.restconfig;

import play.Play;

/**
 * Implementation of a {@link RestServiceConfig} to use the EEPPI Task Template Service.
 * Loads the configuration from the play application configuration file.
 *
 * @author cbi
 */
public class EEPPITaskTemplateServConf implements RestServiceConfig {

	@Override
	public String getUrl() {
		return Play.application().configuration().getString("service.eppi.tasktemplate.url");
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

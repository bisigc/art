package dao;

import java.io.Serializable;

import utils.restconfig.RestServiceConfig;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;

public class EEPPITaskTemplateDAORestImpl<T, PK extends Serializable> extends GenericDAORestImpl<T, PK> {
	
	@Inject
	public EEPPITaskTemplateDAORestImpl(TypeLiteral<T> model, @Named("EEPPITaskTemplateServConf") RestServiceConfig config) {
		super(model, config);
	}

}

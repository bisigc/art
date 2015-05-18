package dao;

import java.io.Serializable;

import models.AbstractModel;
import utils.restconfig.RestServiceConfig;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;

public class EEPPITaskTemplateDAORestImpl<T extends AbstractModel, PK extends Serializable> extends GenericDAORestImpl<T, PK> {
	
	@Inject
	public EEPPITaskTemplateDAORestImpl(TypeLiteral<T> model, @Named("EEPPITaskTemplateServConf") RestServiceConfig config) {
	//public EEPPITaskTemplateDAORestImpl(TypeLiteral<T> model, EEPPITaskTemplateServConf config) {
		super(model, config);
	}

}

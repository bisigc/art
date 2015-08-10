package dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import models.AbstractModel;
import utils.restconfig.RestServiceConfig;

import com.google.inject.TypeLiteral;

public class EEPPITaskTemplateDAORestImpl<T extends AbstractModel, PK extends Serializable> extends GenericDAORestImpl<T, PK> {
	
	@Inject
	public EEPPITaskTemplateDAORestImpl(TypeLiteral<T> model, @Named("EEPPITaskTemplateServConf") RestServiceConfig config) {
	//public EEPPITaskTemplateDAORestImpl(TypeLiteral<T> model, EEPPITaskTemplateServConf config) {
		super(model, config);
	}

}

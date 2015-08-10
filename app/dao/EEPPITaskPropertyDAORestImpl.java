package dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.inject.Named;

import models.AbstractModel;
import utils.restconfig.RestServiceConfig;

import com.google.inject.TypeLiteral;

public class EEPPITaskPropertyDAORestImpl<T extends AbstractModel, PK extends Serializable> extends GenericDAORestImpl<T, PK> {
	
	@Inject
	public EEPPITaskPropertyDAORestImpl(TypeLiteral<T> model, @Named("EEPPITaskPropertyServConf") RestServiceConfig config) {
	//public EEPPITaskPropertyDAORestImpl(TypeLiteral<T> model, EEPPITaskPropertyServConf config) {
		super(model, config);
	}

}

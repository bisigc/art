package dao;

import java.io.Serializable;

import utils.restconfig.RestServiceConfig;

import com.google.inject.Inject;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Named;

public class EEPPITaskPropertyDAORestImpl<T, PK extends Serializable> extends GenericDAORestImpl<T, PK> {
	
	@Inject
	public EEPPITaskPropertyDAORestImpl(TypeLiteral<T> model, @Named("EEPPITaskPropertyServConf") RestServiceConfig config) {
		super(model, config);
	}

}

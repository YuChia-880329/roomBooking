package tmpl.trans.bean.model;

import tmpl.checker.Checker;
import tmpl.exception.WoCheckerException;

public interface ModelWoTransChecked<M, D, E extends WoCheckerException, C extends Checker<D, E>> extends ModelWoTransEx<M, D, E> {
	
	
	@Override
	public default M dtoToBeanImpl(D dto) throws E {
		
		C checker = getChecker();
		checker.check(dto);
		return ModelWoTransEx.super.dtoToBeanImpl(dto);
	}


	public C getChecker();
}

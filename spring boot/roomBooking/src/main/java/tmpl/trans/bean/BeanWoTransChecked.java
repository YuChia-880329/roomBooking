package tmpl.trans.bean;

import tmpl.checker.Checker;
import tmpl.exception.WoCheckerException;

public interface BeanWoTransChecked<B, D, E extends WoCheckerException, C extends Checker<D, E>> extends BeanWoTransEx<B, D, E> {
	
	
	@Override
	public default B bToAImpl(D dto) throws E {
		
		C checker = getChecker();
		checker.check(dto);
		return BeanWoTransEx.super.bToAImpl(dto);
	}


	public C getChecker();
}

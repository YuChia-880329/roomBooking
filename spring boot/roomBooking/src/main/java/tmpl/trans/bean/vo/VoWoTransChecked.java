package tmpl.trans.bean.vo;

import tmpl.checker.Checker;
import tmpl.exception.WoCheckerException;

public interface VoWoTransChecked<V, D, E extends WoCheckerException, C extends Checker<D, E>> extends VoWoTransEx<V, D, E> {
	
	
	@Override
	public default V dtoToBeanImpl(D dto) throws E {
		
		C checker = getChecker();
		checker.check(dto);
		return VoWoTransEx.super.dtoToBeanImpl(dto);
	}


	public C getChecker();
}

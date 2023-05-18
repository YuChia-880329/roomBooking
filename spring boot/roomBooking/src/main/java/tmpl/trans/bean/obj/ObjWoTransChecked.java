package tmpl.trans.bean.obj;

import tmpl.checker.Checker;
import tmpl.exception.WoCheckerException;

public interface ObjWoTransChecked<O, D, E extends WoCheckerException, C extends Checker<D, E>> extends ObjWoTransEx<O, D, E> {
	
	
	@Override
	public default O dtoToBeanImpl(D dto) throws E {
		
		C checker = getChecker();
		checker.check(dto);
		return ObjWoTransEx.super.dtoToBeanImpl(dto);
	}


	public C getChecker();
}

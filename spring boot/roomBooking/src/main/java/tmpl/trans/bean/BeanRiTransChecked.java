package tmpl.trans.bean;

import tmpl.checker.Checker;
import tmpl.exception.RiCheckerException;

public interface BeanRiTransChecked<B, D, E extends RiCheckerException, C extends Checker<B, E>> extends BeanRiTransEx<B, D, E> {
	

	@Override
	public default D aToBImpl(B bean) throws E {
		
		C checker = getChecker();
		checker.check(bean);
		return BeanRiTransEx.super.aToBImpl(bean);
	}


	public C getChecker();
}

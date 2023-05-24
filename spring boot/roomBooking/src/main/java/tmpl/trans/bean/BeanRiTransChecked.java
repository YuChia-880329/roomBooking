package tmpl.trans.bean;

import tmpl.checker.Checker;

public interface BeanRiTransChecked<B, D, C extends Checker<B>> extends BeanRiTrans<B, D> {
	

	@Override
	public default D aToBImpl(B bean) {
		
		C checker = getChecker();
		checker.check(bean);
		return BeanRiTrans.super.aToBImpl(bean);
	}


	public C getChecker();
}

package tmpl.trans.bean;

import tmpl.checker.Checker;

public interface BeanWoTransChecked<B, D, C extends Checker<D>> extends BeanWoTrans<B, D> {
	
	
	@Override
	public default B bToAImpl(D dto) {
		
		C checker = getChecker();
		checker.check(dto);
		return BeanWoTrans.super.bToAImpl(dto);
	}


	public C getChecker();
}

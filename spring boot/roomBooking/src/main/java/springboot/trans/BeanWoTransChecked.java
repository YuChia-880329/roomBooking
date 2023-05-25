package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.BeanWoTrans;

public abstract class BeanWoTransChecked<B, D, C extends Checker<D>> implements BeanWoTrans<B, D> {
	
	protected C checker;
	
	
	@Override
	public B bToAImpl(D dto) {
		
		checker.check(dto);
		return BeanWoTrans.super.bToAImpl(dto);
	}


	public abstract void setChecker(C checker);
}

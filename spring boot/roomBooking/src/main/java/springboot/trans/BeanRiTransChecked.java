package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.BeanRiTrans;

public abstract class BeanRiTransChecked<B, D, C extends Checker<B>> implements BeanRiTrans<B, D> {
	
	protected C checker;
	

	@Override
	public D aToBImpl(B bean) {
		
		checker.check(bean);
		return BeanRiTrans.super.aToBImpl(bean);
	}


	public abstract void setChecker(C checker);
}

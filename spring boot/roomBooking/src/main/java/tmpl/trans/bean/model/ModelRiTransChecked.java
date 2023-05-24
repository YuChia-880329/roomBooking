package tmpl.trans.bean.model;

import tmpl.checker.Checker;

public interface ModelRiTransChecked<M, D, C extends Checker<M>> extends ModelRiTrans<M, D> {
	

	@Override
	public default D beanToDtoImpl(M model) {
		
		C checker = getChecker();
		checker.check(model);
		return ModelRiTrans.super.beanToDtoImpl(model);
	}


	public C getChecker();
}

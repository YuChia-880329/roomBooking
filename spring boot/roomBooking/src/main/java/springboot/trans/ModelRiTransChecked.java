package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.model.ModelRiTrans;

public abstract class ModelRiTransChecked<M, D, C extends Checker<M>> implements ModelRiTrans<M, D> {
	
	protected C checker;
	
	@Override
	public D beanToDtoImpl(M model) {
		
		checker.check(model);
		return ModelRiTrans.super.beanToDtoImpl(model);
	}


	public abstract void setChecker(C checker);
}

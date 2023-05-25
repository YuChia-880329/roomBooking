package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.model.ModelWoTrans;

public abstract class ModelWoTransChecked<M, D, C extends Checker<D>> implements ModelWoTrans<M, D> {
	
	protected C checker;
	
	@Override
	public M dtoToBeanImpl(D dto) {
		
		checker.check(dto);
		return ModelWoTrans.super.dtoToBeanImpl(dto);
	}


	public abstract void setChecker(C checker);
}

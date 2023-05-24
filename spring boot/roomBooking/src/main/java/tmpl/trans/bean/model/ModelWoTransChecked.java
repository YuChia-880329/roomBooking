package tmpl.trans.bean.model;

import tmpl.checker.Checker;

public interface ModelWoTransChecked<M, D, C extends Checker<D>> extends ModelWoTrans<M, D> {
	
	
	@Override
	public default M dtoToBeanImpl(D dto) {
		
		C checker = getChecker();
		checker.check(dto);
		return ModelWoTrans.super.dtoToBeanImpl(dto);
	}


	public C getChecker();
}

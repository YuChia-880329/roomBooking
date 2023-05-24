package tmpl.trans.bean.obj;

import tmpl.checker.Checker;

public interface ObjWoTransChecked<O, D, C extends Checker<D>> extends ObjWoTrans<O, D> {
	
	
	@Override
	public default O dtoToBeanImpl(D dto) {
		
		C checker = getChecker();
		checker.check(dto);
		return ObjWoTrans.super.dtoToBeanImpl(dto);
	}


	public C getChecker();
}

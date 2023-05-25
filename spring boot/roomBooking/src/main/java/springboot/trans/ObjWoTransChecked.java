package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.obj.ObjWoTrans;

public abstract class ObjWoTransChecked<O, D, C extends Checker<D>> implements ObjWoTrans<O, D> {
	
	protected C checker;
	
	@Override
	public O dtoToBeanImpl(D dto) {
		
		checker.check(dto);
		return ObjWoTrans.super.dtoToBeanImpl(dto);
	}


	public abstract void setChecker(C checker);
}

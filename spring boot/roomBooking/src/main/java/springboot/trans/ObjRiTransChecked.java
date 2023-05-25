package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.obj.ObjRiTrans;

public abstract class ObjRiTransChecked<O, D, C extends Checker<O>> implements ObjRiTrans<O, D> {
	
	protected C checker;

	@Override
	public D beanToDtoImpl(O obj) {
		
		checker.check(obj);
		return ObjRiTrans.super.beanToDtoImpl(obj);
	}


	public abstract void setChecker(C checker);
}

package tmpl.trans.bean.obj;

import tmpl.checker.Checker;

public interface ObjRiTransChecked<O, D, C extends Checker<O>> extends ObjRiTrans<O, D> {
	

	@Override
	public default D beanToDtoImpl(O obj) {
		
		C checker = getChecker();
		checker.check(obj);
		return ObjRiTrans.super.beanToDtoImpl(obj);
	}


	public C getChecker();
}

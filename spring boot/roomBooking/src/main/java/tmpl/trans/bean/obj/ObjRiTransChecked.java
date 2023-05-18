package tmpl.trans.bean.obj;

import tmpl.checker.Checker;
import tmpl.exception.RiCheckerException;

public interface ObjRiTransChecked<O, D, E extends RiCheckerException, C extends Checker<O, E>> extends ObjRiTransEx<O, D, E> {
	

	@Override
	public default D beanToDtoImpl(O obj) throws E {
		
		C checker = getChecker();
		checker.check(obj);
		return ObjRiTransEx.super.beanToDtoImpl(obj);
	}


	public C getChecker();
}

package tmpl.trans.bean.model;

import tmpl.checker.Checker;
import tmpl.exception.RiCheckerException;

public interface ModelRiTransChecked<M, D, E extends RiCheckerException, C extends Checker<M, E>> extends ModelRiTransEx<M, D, E> {
	

	@Override
	public default D beanToDtoImpl(M model) throws E {
		
		C checker = getChecker();
		checker.check(model);
		return ModelRiTransEx.super.beanToDtoImpl(model);
	}


	public C getChecker();
}

package tmpl.trans.bean.vo;

import tmpl.checker.Checker;
import tmpl.exception.RiCheckerException;

public interface VoRiTransChecked<V, D, E extends RiCheckerException, C extends Checker<V, E>> extends VoRiTransEx<V, D, E> {
	

	@Override
	public default D beanToDtoImpl(V vo) throws E {
		
		C checker = getChecker();
		checker.check(vo);
		return VoRiTransEx.super.beanToDtoImpl(vo);
	}


	public C getChecker();
}

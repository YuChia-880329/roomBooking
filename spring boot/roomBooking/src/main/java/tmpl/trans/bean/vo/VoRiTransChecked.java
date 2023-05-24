package tmpl.trans.bean.vo;

import tmpl.checker.Checker;

public interface VoRiTransChecked<V, D, C extends Checker<V>> extends VoRiTrans<V, D> {
	

	@Override
	public default D beanToDtoImpl(V vo) {
		
		C checker = getChecker();
		checker.check(vo);
		return VoRiTrans.super.beanToDtoImpl(vo);
	}


	public C getChecker();
}

package tmpl.trans.bean.vo;

import tmpl.checker.Checker;

public interface VoWoTransChecked<V, D, C extends Checker<D>> extends VoWoTrans<V, D> {
	
	
	@Override
	public default V dtoToBeanImpl(D dto) {
		
		C checker = getChecker();
		checker.check(dto);
		return VoWoTrans.super.dtoToBeanImpl(dto);
	}


	public C getChecker();
}

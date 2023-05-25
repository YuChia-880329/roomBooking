package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.vo.VoWoTrans;

public abstract class VoWoTransChecked<V, D, C extends Checker<D>> implements VoWoTrans<V, D> {
	
	protected C checker;
	
	@Override
	public V dtoToBeanImpl(D dto) {
		
		checker.check(dto);
		return VoWoTrans.super.dtoToBeanImpl(dto);
	}


	public abstract void setChecker(C checker);
}

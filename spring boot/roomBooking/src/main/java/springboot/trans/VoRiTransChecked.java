package springboot.trans;

import tmpl.checker.Checker;
import tmpl.trans.bean.vo.VoRiTrans;

public abstract class VoRiTransChecked<V, D, C extends Checker<V>> implements VoRiTrans<V, D> {
	
	protected C checker;
	
	@Override
	public D beanToDtoImpl(V vo) {
		
		checker.check(vo);
		return VoRiTrans.super.beanToDtoImpl(vo);
	}


	public abstract void setChecker(C checker);
}

package springboot.memory.repo;

import java.util.List;

import tmpl.trans.Trans;

public abstract class RepoObjTrans<O, D> implements Trans<O, D> {

	public List<D> objListToDtoList(List<O> objList){
		
		return aListToBList(objList);
	}
	public D objToDto(O obj) {
		
		return aToB(obj);
	}
	
	
	@Override
	public D aToBImpl(O obj) {
		
		return objToDtoImpl(obj);
	}
	
	
	protected abstract D objToDtoImpl(O obj);
}

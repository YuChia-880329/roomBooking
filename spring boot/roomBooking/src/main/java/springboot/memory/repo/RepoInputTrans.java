package springboot.memory.repo;

import java.util.List;

import tmpl.trans.bean.obj.ObjRiTrans;
import tmpl.trans.bean.obj.ObjWoTrans;

public abstract class RepoInputTrans<I, P> implements ObjRiTrans<I, P>, ObjWoTrans<I, P> {

	public I dtoToInput(P dto) {
		
		return dtoToObj(dto);
	}
	public P inputToDto(I inputObj) {
		
		return objToDto(inputObj);
	}
	
	public List<I> dtoListToInputList(List<P> dtoList){
		
		return dtoListToObjList(dtoList);
	}
	public List<P> inputListToDtoList(List<I> inputObjList){
		
		return objListToDtoList(inputObjList);
	}

	
	
	@Override
	public I dtoToObjImpl(P dto) {
		
		return dtoToInputImpl(dto);
	}
	@Override
	public P objToDtoImpl(I inputObj) {
		
		return inputToDtoImpl(inputObj);
	}
	
	
	protected abstract I dtoToInputImpl(P dto);
	protected abstract P inputToDtoImpl(I inputObj);
}

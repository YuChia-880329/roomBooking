package springboot.memory.repo;

import java.util.List;

import tmpl.trans.bean.obj.ObjRiTrans;
import tmpl.trans.bean.obj.ObjWoTrans;

public abstract class RepoInputTrans<I, D> implements ObjRiTrans<I, D>, ObjWoTrans<I, D> {

	public I dtoToInput(D dto) {
		
		return dtoToObj(dto);
	}
	public D inputToDto(I input) {
		
		return objToDto(input);
	}
	
	public List<I> dtoListToInputList(List<D> dtoList){
		
		return dtoListToObjList(dtoList);
	}
	public List<D> inputListToDtoList(List<I> inputList){
		
		return objListToDtoList(inputList);
	}

	
	
	@Override
	public I dtoToObjImpl(D dto) {
		
		return dtoToInputImpl(dto);
	}
	@Override
	public D objToDtoImpl(I input) {
		
		return inputToDtoImpl(input);
	}
	
	
	protected abstract I dtoToInputImpl(D dto);
	protected abstract D inputToDtoImpl(I input);
}

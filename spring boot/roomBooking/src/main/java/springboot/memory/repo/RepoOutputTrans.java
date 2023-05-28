package springboot.memory.repo;

import java.util.List;

import tmpl.trans.bean.obj.ObjRiTrans;
import tmpl.trans.bean.obj.ObjWoTrans;

public abstract class RepoOutputTrans<O, D> implements ObjRiTrans<O, D>, ObjWoTrans<O, D> {

	public O dtoToOutput(D dto) {
		
		return dtoToObj(dto);
	}
	public D outputToDto(O output) {
		
		return objToDto(output);
	}
	
	public List<O> dtoListToOutputList(List<D> dtoList){
		
		return dtoListToObjList(dtoList);
	}
	public List<D> outputListToDtoList(List<O> outputList){
		
		return objListToDtoList(outputList);
	}

	
	
	@Override
	public O dtoToObjImpl(D dto) {
		
		return dtoToOutputImpl(dto);
	}
	@Override
	public D objToDtoImpl(O output) {
		
		return outputToDtoImpl(output);
	}
	
	
	protected abstract O dtoToOutputImpl(D dto);
	protected abstract D outputToDtoImpl(O output);
}

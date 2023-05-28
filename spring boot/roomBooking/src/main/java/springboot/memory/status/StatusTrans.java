package springboot.memory.status;

import java.util.List;

import tmpl.trans.bean.obj.ObjRiTrans;
import tmpl.trans.bean.obj.ObjWoTrans;

public abstract class StatusTrans<S, D> implements ObjRiTrans<S, D>, ObjWoTrans<S, D> {

	public S dtoToStatus(D dto) {
		
		return dtoToObj(dto);
	}
	public D statusToDto(S status) {
		
		return objToDto(status);
	}
	
	public List<S> dtoListToStatusList(List<D> dtoList){
		
		return dtoListToObjList(dtoList);
	}
	public List<D> statusListToDtoList(List<S> statusList){
		
		return objListToDtoList(statusList);
	}

	
	
	@Override
	public S dtoToObjImpl(D dto) {
		
		return dtoToStatusImpl(dto);
	}
	@Override
	public D objToDtoImpl(S status) {
		
		return statusToDtoImpl(status);
	}
	
	
	protected abstract S dtoToStatusImpl(D dto);
	protected abstract D statusToDtoImpl(S status);
}

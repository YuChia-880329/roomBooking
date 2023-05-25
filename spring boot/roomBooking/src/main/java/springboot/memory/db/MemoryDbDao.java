package springboot.memory.db;

import java.util.List;

public abstract class MemoryDbDao<P, O, D, M extends MemoryDb<P, O>, T extends MemoryDbTrans<P, O, D>> {

	protected M memory;
	protected T trans;
	
	protected MemoryDbDao(M memory) {
		
		this.memory = memory;
	}
	
	public List<D> searchAll(){
		
		return trans.paoMapToDtoList(memory.getAll());
	}
	public D searchByPk(P pk) {
		
		return trans.paoToDto(
				new PkAndObj<>(pk, memory.getByPK(pk)));
	}
	public D insert(D dto) {
		
		P pk = trans.dtoToPkImpl(dto);
		
		return trans.paoToDto(
				new PkAndObj<>(pk, memory.add(pk, trans.dtoToObjImpl(dto))));
	}
	public D update(D dto) {
		
		P pk = trans.dtoToPkImpl(dto);
		
		return trans.paoToDto(
				new PkAndObj<>(pk, memory.update(pk, trans.dtoToObjImpl(dto))));
	}
	public D delete(P pk) {
		
		return trans.paoToDto(
				new PkAndObj<>(pk, memory.delete(pk)));
	}
	
	
	protected abstract void setTrans(T trans);
}

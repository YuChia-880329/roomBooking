package tmpl.memory.db;

import java.util.List;

public abstract class MemoryDbDaoTemplate<P, O, D, M extends MemoryDb<P, O>, T extends MemoryDbTrans<P, O, D>> {

	protected M memory;
	protected T transformer;
	
	protected MemoryDbDaoTemplate(M memory) {
		
		this.memory = memory;
		transformer = getTransformer();
	}
	
	public List<D> searchAll(){
		
		return transformer.paoMapToDtoList(memory.getAll());
	}
	public D searchByPk(P pk) {
		
		return transformer.paoToDto(
				new PkAndObj<>(pk, memory.getByPK(pk)));
	}
	public D insert(D dto) {
		
		P pk = transformer.dtoToPkImpl(dto);
		
		return transformer.paoToDto(
				new PkAndObj<>(pk, memory.add(pk, transformer.dtoToObjImpl(dto))));
	}
	public D update(D dto) {
		
		P pk = transformer.dtoToPkImpl(dto);
		
		return transformer.paoToDto(
				new PkAndObj<>(pk, memory.update(pk, transformer.dtoToObjImpl(dto))));
	}
	public D delete(P pk) {
		
		return transformer.paoToDto(
				new PkAndObj<>(pk, memory.delete(pk)));
	}
	
	
	protected abstract T getTransformer();
}

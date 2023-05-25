package springboot.memory.status;

public abstract class StatusDao<O, D, C extends Status<O>, T extends StatusTrans<O, D>> {

	protected C cache;
	protected T trans;
	
	protected StatusDao(C cache) {
		
		this.cache = cache;
	}
	
	
	public D getStatus() {
		
		return trans.objToDto(cache.getStatus());
	}
	public void setStatus(D dto) {
		
		cache.setStatus(trans.dtoToObj(dto));
	}
	public void clearStatus() {
		
		cache.clearStatus();
	}
	
	
	protected abstract void setTrans(T trans);
}

package tmpl.memory.statusCache;

public abstract class StatusCacheDao<O, D, C extends StatusCache<O>, T extends StatusCacheTrans<O, D>> {

	protected C cache;
	protected T trans;
	
	protected StatusCacheDao(C cache) {
		
		this.cache = cache;
		this.trans = getTrans();
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
	
	
	
	protected abstract T getTrans();
}

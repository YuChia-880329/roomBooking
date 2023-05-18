package tmpl.memory.cache;

import java.util.List;

public abstract class CacheDao<O, D, C extends Cache<O>, T extends CacheTrans<O, D>> {

	protected C cache;
	protected T trans;
	
	protected CacheDao(C cache) {
		
		this.cache = cache;
		this.trans = getTrans();
	}
	
	public void save(D dto) {
		
		cache.save(trans.dtoToObj(dto));
	}
	public List<D> use(boolean needClear){
		
		return trans.objListToDtoList(cache.use(needClear));
	}
	public void clearCache() {
		
		cache.clearCache();
	}
	
	
	protected abstract T getTrans();
}

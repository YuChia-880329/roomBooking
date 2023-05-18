package tmpl.memory.statusCache;

public abstract class StatusCache<O> {

	private O status;
	
	protected StatusCache() {
		
		status = null;
	}
	
	public O getStatus() {
		
		if(status == null)
			return ifNull();
		return status;
	}
	
	public void setStatus(O status) {
		
		this.status = status;
	}
	
	public void clearStatus() {
		
		status = null;
	}
	
	protected abstract O ifNull();
}

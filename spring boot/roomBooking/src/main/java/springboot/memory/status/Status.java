package springboot.memory.status;

public abstract class Status<O> {

	private O status;
	
	protected Status() {
		
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

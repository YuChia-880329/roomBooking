package springboot.memory.status;

public abstract class StatusDao<O, D, C extends Status<O>, T extends StatusTrans<O, D>> {

	protected C memory;
	protected T trans;
	
	protected StatusDao(C memory) {
		
		this.memory = memory;
	}
	
	
	public D getStatus() {
		
		return trans.objToDto(memory.getStatus());
	}
	public void setStatus(D dto) {
		
		memory.setStatus(trans.dtoToObj(dto));
	}
	public void clearStatus() {
		
		memory.clearStatus();
	}
	
	
	protected abstract void setTrans(T trans);
}

package springboot.memory.repo;

public abstract class Repo<I, O> {

	protected I lastInput;
	protected O obj;
	
	protected Repo() {
		
		init();
		this.lastInput = initialInput();
		this.obj = update(lastInput);
	}
	
	public O getObj(I input) {
		
		lastInput = input;
		if(isNeedUpdate(input))
			obj = update(input);
		return obj;
	}
	public I getLastInput() {
		
		return lastInput;
	}
	
	protected void init() {
		
	}
	
	protected abstract I initialInput();
	protected abstract boolean isNeedUpdate(I input);
	protected abstract O update(I input);
}

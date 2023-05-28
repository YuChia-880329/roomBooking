package springboot.memory.repo;

import org.springframework.beans.factory.InitializingBean;

public abstract class Repo<I, S, O> implements InitializingBean {

	protected I lastInput;
	protected S storeObj;
	
	protected Repo() {
		
		this.lastInput = null;
		this.storeObj = null;
	}
	
	protected void init() {
	}
	
	public O getObj(I input) {
		
		if(isNeedUpdate(input))
			storeObj = update(input);
		lastInput = input;
		return getOutput(input);
	}
	public I getLastInput() {
		
		return lastInput;
	}

	
	
	@Override
	public void afterPropertiesSet() throws Exception {
		
		init();
		this.lastInput = initialInput();
		this.storeObj = update(lastInput);
	}
	
	protected abstract I initialInput();
	protected abstract boolean isNeedUpdate(I input);
	protected abstract S update(I input);
	protected abstract O getOutput(I input);
}

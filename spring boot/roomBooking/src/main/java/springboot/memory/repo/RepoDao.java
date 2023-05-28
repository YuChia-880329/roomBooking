package springboot.memory.repo;

public abstract class RepoDao<I, S, O, DI, DO, R extends Repo<I, S, O>, TI extends RepoInputTrans<I, DI>, TO extends RepoOutputTrans<O, DO>> {

	protected R repo;
	protected TI inputTrans;
	protected TO outputTrans;
	
	protected RepoDao(R repo) {
		
		this.repo = repo;
	}
	
	public DO getObj(DI input) {
		
		return outputTrans.outputToDto(
				repo.getObj(
						inputTrans.dtoToInput(input)));
	}

	

	public abstract void setInputTrans(TI inputTrans);
	public abstract void setOutputTrans(TO outputTrans);
}

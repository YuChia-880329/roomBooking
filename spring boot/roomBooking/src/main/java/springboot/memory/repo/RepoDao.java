package springboot.memory.repo;

public abstract class RepoDao<I, O, P, D, R extends Repo<I, O>, T extends RepoInputTrans<I, P>, S extends RepoObjTrans<O, D>> {

	protected R repo;
	protected T inputTrans;
	protected S objTrans;
	
	protected RepoDao(R repo) {
		
		this.repo = repo;
	}
	
	public D getObjDto(P inputDto) {
		
		return objTrans.objToDto(
				repo.getObj(
						inputTrans.dtoToInput(inputDto)));
	}
	public P getLastInput() {
		
		return inputTrans.inputToDto(repo.getLastInput());
	}
	

	public abstract void setInputTrans(T inputTrans);
	public abstract void setObjTrans(S objTrans);
}

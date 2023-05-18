package tmpl.memory.repo;

public abstract class RepoDao<I, O, P, D, R extends Repo<I, O>, T extends RepoInputTrans<I, P>, S extends RepoObjTrans<O, D>> {

	protected R repo;
	protected T inputTrans;
	protected S objTrans;
	
	protected RepoDao(R repository) {
		
		this.repo = repository;
		inputTrans = getInputTrans();
		objTrans = getObjTrans();
	}
	
	public D getObjDto(P inputDto) {
		
		return objTrans.objToDto(
				repo.getObj(
						inputTrans.dtoToInput(inputDto)));
	}
	

	protected abstract T getInputTrans();
	protected abstract S getObjTrans();
}

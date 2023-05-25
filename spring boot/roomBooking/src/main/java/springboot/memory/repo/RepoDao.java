package springboot.memory.repo;

public abstract class RepoDao<I, O, P, D, R extends Repo<I, O>, T extends RepoInputTrans<I, P>, S extends RepoObjTrans<O, D>> {

	protected R repo;
	protected T inputTrans;
	protected S objTrans;
	
	protected RepoDao(R repository) {
		
		this.repo = repository;
	}
	
	public D getObjDto(P inputDto) {
		
		return objTrans.objToDto(
				repo.getObj(
						inputTrans.dtoToInput(inputDto)));
	}
	

	protected abstract void setInputTrans(T inputTrans);
	protected abstract void setObjTrans(S objTrans);
}

package springboot.dao.model.inner;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.trans.model.ModelTrans;

public abstract class DaoInner<M, ID, D, T extends ModelTrans<M, D>, A extends JpaRepository<M, ID>> {

	protected A dao;
	protected T trans;

	
	public List<D> findAll(){
		
		List<M> list = dao.findAll();
		return trans.modelListToDtoList(list);
	}
	
	public Optional<D> findById(ID id) {
		
		Optional<M> modelOp = dao.findById(id);
		
		return modelOp.map(model -> trans.modelToDto(model));
	}
	
	protected D saveImpl(D dto, ID id) {
		
		return trans.modelToDto(
				dao.save(
						copyModel(
								dao.findById(id).get(), trans.dtoToModel(dto))));
	}
	
	
	protected M copyModel(M model1, M model2) {
		
		return model1;
	}
	public abstract void setDao(A dao);
	public abstract void setTrans(T trans);
}

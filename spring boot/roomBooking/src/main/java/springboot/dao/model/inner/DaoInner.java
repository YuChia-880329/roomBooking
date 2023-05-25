package springboot.dao.model.inner;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.trans.model.ModelTrans;

public abstract class DaoInner<M, ID, D, T extends ModelTrans<M, D>, A extends JpaRepository<M, ID>> {

	protected A dao;
	protected T trans;

	
	public Optional<D> findById(ID id) {
		
		Optional<M> modelOp = dao.findById(id);
		
		return modelOp.map(model -> trans.modelToDto(model));
	}
	
	
	public abstract void setDao(A dao);
	public abstract void setTrans(T trans);
}

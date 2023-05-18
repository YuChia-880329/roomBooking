package tmpl.trans.bean.model;

import java.util.List;

import tmpl.trans.bean.BeanWoTrans;

public interface ModelWoTrans<M, D> extends BeanWoTrans<M, D> {

	public default M dtoToModel(D dto) {
		
		return dtoToBean(dto);
	}
	
	public default List<M> dtoListToModelList(List<D> dtoList){
		
		return dtoListToBeanList(dtoList);
	}
	
	
	@Override
	public default M dtoToBeanImpl(D dto) {
		
		return dtoToModelImpl(dto);
	}

	public M dtoToModelImpl(D dto);
}

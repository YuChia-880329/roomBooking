package tmpl.trans.bean.model;

import java.util.List;

import tmpl.trans.bean.BeanWoTransEx;

public interface ModelWoTransEx<M, D, E extends Exception> extends BeanWoTransEx<M, D, E> {

	public default M dtoToModel(D dto) throws E {
		
		return dtoToBean(dto);
	}
	
	public default List<M> dtoListToModelList(List<D> dtoList) throws E{
		
		return dtoListToBeanList(dtoList);
	}
	
	@Override
	public default M dtoToBeanImpl(D dto) throws E {
		
		return dtoToModelImpl(dto);
	}

	public M dtoToModelImpl(D dto) throws E;
}

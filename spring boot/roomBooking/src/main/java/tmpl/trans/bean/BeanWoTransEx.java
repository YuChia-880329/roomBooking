package tmpl.trans.bean;

import java.util.List;

import tmpl.trans.TransRevsEx;

public interface BeanWoTransEx<B, D, E extends Exception> extends TransRevsEx<B, D, E> {

	public default B dtoToBean(D dto) throws E {
		
		return bToA(dto);
	}
	
	public default List<B> dtoListToBeanList(List<D> dtoList) throws E{
		
		return bListToAList(dtoList);
	}
	
	
	@Override
	default B bToAImpl(D dto) throws E {
		
		return dtoToBeanImpl(dto);
	}


	public B dtoToBeanImpl(D dto) throws E;
}

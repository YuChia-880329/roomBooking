package tmpl.trans.bean.vo;

import java.util.List;

import tmpl.trans.bean.BeanWoTransEx;

public interface VoWoTransEx<V, D, E extends Exception> extends BeanWoTransEx<V, D, E> {

	public default V dtoToVo(D dto) throws E {
		
		return dtoToBean(dto);
	}
	
	public default List<V> dtoListToVoList(List<D> dtoList) throws E{
		
		return dtoListToBeanList(dtoList);
	}
	
	@Override
	public default V dtoToBeanImpl(D dto) throws E {
		
		return dtoToVoImpl(dto);
	}

	public V dtoToVoImpl(D dto) throws E;
}

package tmpl.trans.bean.vo;

import java.util.List;

import tmpl.trans.bean.BeanRiTransEx;

public interface VoRiTransEx<V, D, E extends Exception> extends BeanRiTransEx<V, D, E> {


	public default D voToDto(V vo) throws E{
		
		return beanToDto(vo);
	}

	public default List<D> voListToDtoList(List<V> voList) throws E{
		
		return beanListToDtoList(voList);
	}


	@Override
	public default D beanToDtoImpl(V vo) throws E {
		
		return voToDtoImpl(vo);
	}


	public D voToDtoImpl(V vo) throws E;
}

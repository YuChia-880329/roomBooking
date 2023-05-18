package tmpl.trans.bean.obj;

import java.util.List;

import tmpl.trans.bean.BeanWoTransEx;

public interface ObjWoTransEx<O, D, E extends Exception> extends BeanWoTransEx<O, D, E> {

	public default O dtoToObj(D dto) throws E {
		
		return dtoToBean(dto);
	}
	
	public default List<O> dtoListToObjList(List<D> dtoList) throws E{
		
		return dtoListToBeanList(dtoList);
	}
	
	@Override
	public default O dtoToBeanImpl(D dto) throws E {
		
		return dtoToObjImpl(dto);
	}

	public O dtoToObjImpl(D dto) throws E;
}

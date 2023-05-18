package tmpl.trans.bean.obj;

import java.util.List;

import tmpl.trans.bean.BeanRiTransEx;

public interface ObjRiTransEx<O, D, E extends Exception> extends BeanRiTransEx<O, D, E> {


	public default D objToDto(O obj) throws E{
		
		return beanToDto(obj);
	}

	public default List<D> objListToDtoList(List<O> objList) throws E{
		
		return beanListToDtoList(objList);
	}


	@Override
	public default D beanToDtoImpl(O obj) throws E {
		
		return objToDtoImpl(obj);
	}


	public D objToDtoImpl(O obj) throws E;
}

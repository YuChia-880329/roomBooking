package tmpl.trans.bean;

import java.util.List;

import tmpl.trans.TransEx;

public interface BeanRiTransEx<B, D, E extends Exception> extends TransEx<B, D, E> {


	public default D beanToDto(B bean) throws E{
		
		return aToB(bean);
	}

	public default List<D> beanListToDtoList(List<B> beanList) throws E{
		
		return aListToBList(beanList);
	}


	@Override
	public default D aToBImpl(B bean) throws E {
		
		return beanToDtoImpl(bean);
	}


	public D beanToDtoImpl(B bean) throws E;
}

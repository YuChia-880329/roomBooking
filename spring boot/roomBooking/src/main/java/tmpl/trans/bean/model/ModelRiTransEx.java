package tmpl.trans.bean.model;

import java.util.List;

import tmpl.trans.bean.BeanRiTransEx;

public interface ModelRiTransEx<M, D, E extends Exception> extends BeanRiTransEx<M, D, E> {


	public default D modelToDto(M model) throws E{
		
		return beanToDto(model);
	}

	public default List<D> modelListToDtoList(List<M> modelList) throws E{
		
		return beanListToDtoList(modelList);
	}


	@Override
	public default D beanToDtoImpl(M model) throws E {
		
		return modelToDtoImpl(model);
	}


	public D modelToDtoImpl(M model) throws E;
}

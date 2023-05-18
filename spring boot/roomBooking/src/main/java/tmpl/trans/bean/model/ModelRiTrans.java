package tmpl.trans.bean.model;

import java.util.List;

import tmpl.trans.bean.BeanRiTrans;

public interface ModelRiTrans<M, D> extends BeanRiTrans<M, D> {

	public default D modelToDto(M model){
		
		return beanToDto(model);
	}

	public default List<D> modelListToDtoList(List<M> modelList){
		
		return beanListToDtoList(modelList);
	}
	
	@Override
	public default D beanToDtoImpl(M model) {
		
		return modelToDtoImpl(model);
	}
	
	
	public D modelToDtoImpl(M model);
}

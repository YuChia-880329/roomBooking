package tmpl.trans.bean.vo;

import java.util.List;

import tmpl.trans.bean.BeanRiTrans;

public interface VoRiTrans<V, D> extends BeanRiTrans<V, D> {

	public default D voToDto(V vo){
		
		return beanToDto(vo);
	}

	public default List<D> voListToDtoList(List<V> voList){
		
		return beanListToDtoList(voList);
	}
	
	@Override
	public default D beanToDtoImpl(V vo) {
		
		return voToDtoImpl(vo);
	}
	
	
	public D voToDtoImpl(V vo);
}

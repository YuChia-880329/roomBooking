package tmpl.trans.bean.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tmpl.trans.bean.BeanRiTrans;

public interface VoRiTrans<V, D> extends BeanRiTrans<V, D> {

	public default D voToDto(V vo){
		
		return beanToDto(vo);
	}

	public default List<D> voArrayToDtoList(V[] voArray){
		
		return beanListToDtoList(new ArrayList<>(Arrays.asList(voArray)));
	}
	
	@Override
	public default D beanToDtoImpl(V vo) {
		
		return voToDtoImpl(vo);
	}
	
	
	public D voToDtoImpl(V vo);
}

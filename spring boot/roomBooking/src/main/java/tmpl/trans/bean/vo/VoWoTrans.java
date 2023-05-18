package tmpl.trans.bean.vo;

import java.util.List;

import tmpl.trans.bean.BeanWoTrans;

public interface VoWoTrans<V, D> extends BeanWoTrans<V, D> {

	public default V dtoToVo(D dto) {
		
		return dtoToBean(dto);
	}
	
	public default List<V> dtoListToVoList(List<D> dtoList){
		
		return dtoListToBeanList(dtoList);
	}
	
	
	@Override
	public default V dtoToBeanImpl(D dto) {
		
		return dtoToVoImpl(dto);
	}

	public V dtoToVoImpl(D dto);
}

package tmpl.trans.bean.vo;

import java.util.List;
import java.util.function.Function;

import tmpl.trans.bean.BeanWoTrans;

public interface VoWoTrans<V, D> extends BeanWoTrans<V, D> {

	public default V dtoToVo(D dto) {
		
		return dtoToBean(dto);
	}
	
	public default V[] dtoListToVoArray(List<D> dtoList, Function<Integer, V[]> arrayFctn){
		
		return dtoListToBeanList(dtoList).toArray(arrayFctn.apply(dtoList.size()));
	}
	
	
	@Override
	public default V dtoToBeanImpl(D dto) {
		
		return dtoToVoImpl(dto);
	}

	public V dtoToVoImpl(D dto);
}

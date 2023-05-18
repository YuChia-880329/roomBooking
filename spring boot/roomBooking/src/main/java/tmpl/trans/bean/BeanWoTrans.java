package tmpl.trans.bean;

import java.util.List;

import tmpl.trans.TransRevs;

public interface BeanWoTrans<B, D> extends TransRevs<B, D> {

	public default B dtoToBean(D dto) {
		
		return bToA(dto);
	}
	
	public default List<B> dtoListToBeanList(List<D> dtoList){
		
		return bListToAList(dtoList);
	}
	
	

	@Override
	default B bToAImpl(D dto) {
		
		return dtoToBeanImpl(dto);
	}

	public B dtoToBeanImpl(D dto);
}

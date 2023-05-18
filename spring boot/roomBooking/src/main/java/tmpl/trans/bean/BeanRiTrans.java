package tmpl.trans.bean;

import java.util.List;

import tmpl.trans.Trans;

public interface BeanRiTrans<B, D> extends Trans<B, D> {

	public default D beanToDto(B bean){
		
		return aToB(bean);
	}

	public default List<D> beanListToDtoList(List<B> beanList){
		
		return aListToBList(beanList);
	}
	
	@Override
	public default D aToBImpl(B bean) {
		
		return beanToDtoImpl(bean);
	}
	
	
	public D beanToDtoImpl(B bean);
}

package tmpl.trans.bean.obj;

import java.util.List;

import tmpl.trans.bean.BeanWoTrans;

public interface ObjWoTrans<O, D> extends BeanWoTrans<O, D> {

	public default O dtoToObj(D dto) {
		
		return dtoToBean(dto);
	}
	
	public default List<O> dtoListToObjList(List<D> dtoList){
		
		return dtoListToBeanList(dtoList);
	}
	
	
	@Override
	public default O dtoToBeanImpl(D dto) {
		
		return dtoToObjImpl(dto);
	}

	public O dtoToObjImpl(D dto);
}

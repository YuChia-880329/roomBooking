package tmpl.trans.bean.obj;

import java.util.List;

import tmpl.trans.bean.BeanRiTrans;

public interface ObjRiTrans<O, D> extends BeanRiTrans<O, D> {

	public default D objToDto(O obj){
		
		return beanToDto(obj);
	}

	public default List<D> objListToDtoList(List<O> objList){
		
		return beanListToDtoList(objList);
	}
	
	@Override
	public default D beanToDtoImpl(O obj) {
		
		return objToDtoImpl(obj);
	}
	
	
	public D objToDtoImpl(O obj);
}

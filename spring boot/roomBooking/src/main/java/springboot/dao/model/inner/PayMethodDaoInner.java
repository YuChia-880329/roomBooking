package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.PayMethodDto;
import springboot.dao.model.PayMethodDao;
import springboot.trans.model.PayMethodTrans;

@Repository("model.inner.PayMethodDaoInner")
public class PayMethodDaoInner {

	@Autowired
	@Qualifier("model.PayMethodDao")
	private PayMethodDao dao;
	@Autowired
	@Qualifier("model.PayMethodTrans")
	private PayMethodTrans trans;
	

	
	public List<PayMethodDto> queryAllPayMethods(){
		
		return trans.modelListToDtoList(
				dao.queryAllPayMethods());
	}
}

package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.PayMethodDto;
import springboot.bean.model.PayMethod;
import springboot.dao.model.PayMethodDao;
import springboot.trans.model.PayMethodTrans;

@Repository("model.inner.PayMethodDaoInner")
public class PayMethodDaoInner extends DaoInner<PayMethod, Integer, PayMethodDto, PayMethodTrans, PayMethodDao> {

	@Autowired
	@Qualifier("model.PayMethodDao")
	@Override
	public void setDao(PayMethodDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.PayMethodTrans")
	@Override
	public void setTrans(PayMethodTrans trans) {

		this.trans = trans;
	}
}

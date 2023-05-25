package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.model.HotelAccount;
import springboot.dao.model.HotelAccountDao;
import springboot.trans.model.HotelAccountTrans;

@Repository
public class HotelAccountDaoInner extends DaoInner<HotelAccount, Integer, HotelAccountDto, HotelAccountTrans, HotelAccountDao> {

	@Autowired
	@Override
	public void setDao(HotelAccountDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(HotelAccountTrans trans) {
		
		this.trans = trans;
	}
}

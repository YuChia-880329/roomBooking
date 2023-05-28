package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.model.HotelAccount;
import springboot.dao.model.HotelAccountDao;
import springboot.trans.model.HotelAccountTrans;

@Repository("model.inner.HotelAccountDaoInner")
public class HotelAccountDaoInner extends DaoInner<HotelAccount, Integer, HotelAccountDto, HotelAccountTrans, HotelAccountDao> {

	
	
	public HotelAccountDto findFirstByAccount(String account){
		
		return trans.modelToDto(dao.findFirstByAccount(account));
	}
	
	
	@Autowired
	@Qualifier("model.HotelAccountDao")
	@Override
	public void setDao(HotelAccountDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.HotelAccountTrans")
	@Override
	public void setTrans(HotelAccountTrans trans) {
		
		this.trans = trans;
	}
}

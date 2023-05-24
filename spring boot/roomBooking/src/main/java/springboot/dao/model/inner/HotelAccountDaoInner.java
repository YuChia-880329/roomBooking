package springboot.dao.model.inner;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.dto.model.HotelAccountDto;
import springboot.bean.model.BookingOrder;
import springboot.bean.model.HotelAccount;
import springboot.dao.model.BookingOrderDao;
import springboot.dao.model.HotelAccountDao;
import springboot.trans.model.BookingOrderTrans;
import springboot.trans.model.HotelAccountTrans;

public class HotelAccountDaoInner extends DaoInner<HotelAccount, Integer, HotelAccountDto, HotelAccountTrans, HotelAccountDao> {

	private HotelAccountDao dao;
	private HotelAccountTrans trans;
	
	@Override
	protected HotelAccountDao getDao() {
		
		return dao;
	}
	@Override
	protected HotelAccountTrans getTrans() {
		
		return trans;
	}
}

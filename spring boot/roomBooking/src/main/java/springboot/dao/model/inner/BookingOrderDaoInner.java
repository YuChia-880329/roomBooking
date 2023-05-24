package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.model.BookingOrder;
import springboot.dao.model.BookingOrderDao;
import springboot.trans.model.BookingOrderTrans;

public class BookingOrderDaoInner extends DaoInner<BookingOrder, Integer, BookingOrderDto, BookingOrderTrans, BookingOrderDao> {

	@Autowired
	private BookingOrderDao dao;
	@Autowired
	private BookingOrderTrans trans;
	
	
	
	@Override
	protected BookingOrderDao getDao() {
		
		return dao;
	}
	@Override
	protected BookingOrderTrans getTrans() {
		
		return trans;
	}
}

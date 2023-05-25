package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.model.BookingOrder;
import springboot.dao.model.BookingOrderDao;
import springboot.trans.model.BookingOrderTrans;

@Repository
public class BookingOrderDaoInner extends DaoInner<BookingOrder, Integer, BookingOrderDto, BookingOrderTrans, BookingOrderDao> {

	@Autowired
	@Override
	public void setDao(BookingOrderDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(BookingOrderTrans trans) {
		
		this.trans = trans;
	}
}

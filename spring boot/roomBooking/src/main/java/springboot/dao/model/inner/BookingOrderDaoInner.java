package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.BookingOrderDto;
import springboot.bean.model.BookingOrder;
import springboot.dao.model.BookingOrderDao;
import springboot.trans.model.BookingOrderTrans;

@Repository("model.inner.BookingOrderDaoInner")
public class BookingOrderDaoInner extends DaoInner<BookingOrder, Integer, BookingOrderDto, BookingOrderTrans, BookingOrderDao> {

	@Autowired
	@Qualifier("model.BookingOrderDao")
	@Override
	public void setDao(BookingOrderDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.BookingOrderTrans")
	@Override
	public void setTrans(BookingOrderTrans trans) {
		
		this.trans = trans;
	}
}

package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.HotelDto;
import springboot.bean.model.Hotel;
import springboot.dao.model.HotelDao;
import springboot.trans.model.HotelTrans;

@Repository("model.inner.HotelDaoInner")
public class HotelDaoInner extends DaoInner<Hotel, Integer, HotelDto, HotelTrans, HotelDao> {

	@Autowired
	@Qualifier("model.HotelDao")
	@Override
	public void setDao(HotelDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.HotelTrans")
	@Override
	public void setTrans(HotelTrans trans) {

		this.trans = trans;
	}
}

package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.HotelDto;
import springboot.bean.model.Hotel;
import springboot.dao.model.HotelDao;
import springboot.trans.model.HotelTrans;

@Repository
public class HotelDaoInner extends DaoInner<Hotel, Integer, HotelDto, HotelTrans, HotelDao> {

	@Autowired
	@Override
	public void setDao(HotelDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(HotelTrans trans) {

		this.trans = trans;
	}
}

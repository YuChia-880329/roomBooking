package springboot.service.bk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.bk.vo.hotel.HotelRespDto;
import springboot.bean.dto.model.HotelDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.HotelDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.HotelService")
public class HotelService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.HotelDaoInner")
	private HotelDaoInner hotelDaoInner;
	
	
	public HotelRespDto hotelName() {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		HotelDto hotel = hotelDaoInner.findById(login.getHotelId()).get();
		return HotelRespDto.builder()
				.hotelId(hotel.getId())
				.hotelName(hotel.getName())
				.build();
	}
}

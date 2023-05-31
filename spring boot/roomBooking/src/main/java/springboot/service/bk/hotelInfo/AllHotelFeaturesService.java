package springboot.service.bk.hotelInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.allHotelFeatures.AllHotelFeaturesRespDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;

@Service("bk.hotelInfo")
public class AllHotelFeaturesService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	
	
	public AllHotelFeaturesRespDto allHotelFeatures() {
		
		loginStatusDao.getStatus();
	}
}

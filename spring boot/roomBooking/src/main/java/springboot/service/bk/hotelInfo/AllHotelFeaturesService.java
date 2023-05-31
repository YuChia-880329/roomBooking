package springboot.service.bk.hotelInfo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.allHotelFeatures.AllHotelFeaturesRespDto;
import springboot.bean.dto.bk.hotelInfo.vo.allHotelFeatures.HotelFeatureDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.model.HotelDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.HotelFeatureDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.hotelInfo.AllHotelFeaturesService")
public class AllHotelFeaturesService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.HotelFeatureDaoInner")
	private HotelFeatureDaoInner hotelFeatureDaoInner;
	
	
	public AllHotelFeaturesRespDto allHotelFeatures() {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		List<springboot.bean.dto.model.HotelFeatureDto> hotelFeatures = hotelFeatureDaoInner.findAll();
		return AllHotelFeaturesRespDto.builder()
				.hotelFeatures(toHotelFeaturesVo(hotelFeatures, login.getHotelId()))
				.build();
	}
	
	private List<HotelFeatureDto> toHotelFeaturesVo(List<springboot.bean.dto.model.HotelFeatureDto> hotelFeatures, int hotelId) {
		
		return hotelFeatures.stream()
				.map(hotelFeature -> toHotelFeatureVo(hotelFeature, hotelId))
				.collect(Collectors.toList());
	}
	private HotelFeatureDto toHotelFeatureVo(springboot.bean.dto.model.HotelFeatureDto hotelFeature, int hotelId) {
		
		return HotelFeatureDto.builder()
				.id(hotelFeature.getId())
				.name(hotelFeature.getName())
				.checked(isChecked(hotelFeature.getHotels(), hotelId))
				.build();
	}
	
	private boolean isChecked(List<HotelDto> hotels, int hotelId) {
		
		for(HotelDto hotel : hotels) {
			
			if(hotel.getId() == hotelId)
				return true;
		}
		
		return false;
	}
}

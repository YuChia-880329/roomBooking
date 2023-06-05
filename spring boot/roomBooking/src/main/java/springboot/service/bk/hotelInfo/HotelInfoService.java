package springboot.service.bk.hotelInfo;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.hotelInfo.HotelInfoRespDto;
import springboot.bean.dto.bk.hotelInfo.vo.hotelInfo.ImageDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.model.HotelDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.HotelDaoInner;
import springboot.exception.NotLoginException;
import util.ImageUtil;

@Service("bk.hotelInfo.HotelInfoService")
public class HotelInfoService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.HotelDaoInner")
	private HotelDaoInner hotelDaoInner;
	
	
	public HotelInfoRespDto hotelInfo() {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		Optional<HotelDto> hotelOp = hotelDaoInner.findById(login.getHotelId());
		HotelDto hotel = hotelOp.get();
		return HotelInfoRespDto.builder()
				.name(hotel.getName())
				.sectionCode(hotel.getSectionCode())
				.address(hotel.getAddress())
				.introduction(hotel.getIntroduction())
				.featureIds(hotel.getFeatures().stream()
						.map(f -> f.getId())
						.collect(Collectors.toList()))
				.newFeatureNames(hotel.getNewFeatures().stream()
						.filter(nf -> nf.isChecked())
						.map(nf -> nf.getName())
						.collect(Collectors.toList()))
				.image(toImage(hotel))
				.build();
	}
	
	private ImageDto toImage(HotelDto hotel) {
		
		return ImageDto.builder()
				.imgName(hotel.getImgName())
				.url(ImageUtil.getUrl(hotel.getId(), hotel.getImgName()))
				.build();
	}
}

package springboot.service.fr.hotelPage;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.hotelPage.vo.getInfo.FeatureDto;
import springboot.bean.dto.fr.hotelPage.vo.getInfo.GetInfoReqDto;
import springboot.bean.dto.fr.hotelPage.vo.getInfo.GetInfoRespDto;
import springboot.bean.dto.model.HotelDto;
import springboot.bean.dto.model.NewFeatureDto;
import springboot.dao.model.inner.HotelDaoInner;
import util.ImageUtil;

@Service("fr.hotelPage.GetInfoService")
public class GetInfoService {

	public static final int FEATURE_NUM = 3;
	
	@Autowired
	@Qualifier("model.inner.HotelDaoInner")
	private HotelDaoInner hotelDaoInner;
	
	public GetInfoRespDto getInfo(GetInfoReqDto getInfoReq) {
		
		HotelDto hotel = hotelDaoInner.findById(getInfoReq.getHotelId()).get();
		
		return GetInfoRespDto.builder()
				.imgUrl(ImageUtil.getImgUrl(hotel.getId(), hotel.getImgName()))
				.hotelName(hotel.getName())
				.address(hotel.getAddress())
				.description(hotel.getDescription())
				.features(toFeature(hotel))
				.build();
	}
	
	private List<FeatureDto> toFeature(HotelDto hotel){
		
		class MyInt {
			int index = 1;
		}
		MyInt myInt = new MyInt();
		
		List<FeatureDto> features = hotel.getFeatures().stream()
				.map(feature -> toFeatureVo(feature, myInt.index++))
				.collect(Collectors.toList());
		if(features.size() < FEATURE_NUM) {
			
			int n = FEATURE_NUM - features.size();
			features.addAll(hotel.getNewFeatures().stream()
					.filter(newFeature -> newFeature.isChecked())
					.limit(n)
					.map(newFeature -> toFeatureVo(newFeature, myInt.index++))
					.collect(Collectors.toList()));
		}
			
		return features;
	}
	private FeatureDto toFeatureVo(springboot.bean.dto.model.FeatureDto feature, int index){
		
		return FeatureDto.builder()
				.id(index)
				.name(feature.getName())
				.build();
	}
	private FeatureDto toFeatureVo(NewFeatureDto newFeature, int index) {
		
		return FeatureDto.builder()
				.id(index)
				.name(newFeature.getName())
				.build();
	}
}

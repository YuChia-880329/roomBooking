package springboot.service.bk.hotelInfo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.allFeatures.AllFeaturesRespDto;
import springboot.bean.dto.bk.hotelInfo.vo.allFeatures.FeatureDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.FeatureDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.hotelInfo.AllFeaturesService")
public class AllFeaturesService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.FeatureDaoInner")
	private FeatureDaoInner featureDaoInner;
	
	
	public AllFeaturesRespDto allFeatures() {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		List<springboot.bean.dto.model.FeatureDto> hotelFeatures = featureDaoInner.findAll();
		return AllFeaturesRespDto.builder()
				.features(toFeaturesVo(hotelFeatures, login.getHotelId()))
				.build();
	}
	
	private List<FeatureDto> toFeaturesVo(List<springboot.bean.dto.model.FeatureDto> features, int hotelId) {
		
		return features.stream()
				.map(hotelFeature -> toHotelFeatureVo(hotelFeature, hotelId))
				.collect(Collectors.toList());
	}
	private FeatureDto toHotelFeatureVo(springboot.bean.dto.model.FeatureDto feature, int hotelId) {
		
		return FeatureDto.builder()
				.id(feature.getId())
				.name(feature.getName())
				.build();
	}
}

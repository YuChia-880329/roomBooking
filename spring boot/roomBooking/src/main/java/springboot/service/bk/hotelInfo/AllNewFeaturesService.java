package springboot.service.bk.hotelInfo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.allNewFeatures.AllNewFeaturesRespDto;
import springboot.bean.dto.bk.hotelInfo.vo.allNewFeatures.NewFeatureDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.NewFeatureDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.hotelInfo.AllNewFeaturesService")
public class AllNewFeaturesService {

	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.NewFeatureDaoInner")
	private NewFeatureDaoInner newFeatureDaoInner;
	
	
	public AllNewFeaturesRespDto allNewFeatures() {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		List<springboot.bean.dto.model.NewFeatureDto> newFeatures = 
				newFeatureDaoInner.findByHotelId(login.getHotelId());
	
		return AllNewFeaturesRespDto.builder()
				.newFeatures(toNewFeaturesVo(newFeatures))
				.build();
	}
	
	
	private List<NewFeatureDto> toNewFeaturesVo(List<springboot.bean.dto.model.NewFeatureDto> newFeatures) {
		
		return newFeatures.stream()
				.map(newFeature -> toNewFeatureVo(newFeature))
				.collect(Collectors.toList());
	}
	private NewFeatureDto toNewFeatureVo(springboot.bean.dto.model.NewFeatureDto newFeature) {
		
		return NewFeatureDto.builder()
				.id(newFeature.getId())
				.name(newFeature.getName())
				.build();
	}
}

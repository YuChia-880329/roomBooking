package springboot.service.bk.hotelInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureReqDto;
import springboot.bean.dto.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureRespDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.model.FeatureDto;
import springboot.bean.dto.model.NewFeatureDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.FeatureDaoInner;
import springboot.dao.model.inner.NewFeatureDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.hotelInfo.CheckNewHotelFeatureService")
public class CheckNewHotelFeatureService {

	private static final String ILLEGAL_MSG = "名稱重複";
	
	
	@Autowired
	@Qualifier("bk.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.FeatureDaoInner")
	private FeatureDaoInner hotelFeatureDaoInner;
	@Autowired
	@Qualifier("model.inner.NewFeatureDaoInner")
	private NewFeatureDaoInner newFeatureDaoInner;
	
	
	public CheckNewHotelFeatureRespDto checkNewHotelFeature(CheckNewHotelFeatureReqDto checkNewHotelFeatureReq) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		FeatureDto feature = hotelFeatureDaoInner.queryByName(checkNewHotelFeatureReq.getName());
		List<NewFeatureDto> newFeatures = newFeatureDaoInner.findByNameAndHotelId(checkNewHotelFeatureReq.getName(), login.getHotelId());
		
		boolean pass = (feature==null && newFeatures.size()==0);
		
		return CheckNewHotelFeatureRespDto.builder()
				.pass(pass)
				.msg(pass ? "" : ILLEGAL_MSG)
				.build();
	}
}

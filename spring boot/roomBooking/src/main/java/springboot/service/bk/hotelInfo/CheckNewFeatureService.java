package springboot.service.bk.hotelInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureReqDto;
import springboot.bean.dto.bk.hotelInfo.vo.checkNewFeature.CheckNewFeatureRespDto;
import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.dto.model.FeatureDto;
import springboot.bean.dto.model.NewFeatureDto;
import springboot.dao.bk.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.FeatureDaoInner;
import springboot.dao.model.inner.NewFeatureDaoInner;
import springboot.exception.NotLoginException;

@Service("bk.hotelInfo.CheckNewFeatureService")
public class CheckNewFeatureService {

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
	
	
	public CheckNewFeatureRespDto checkNewFeature(CheckNewFeatureReqDto checkNewFeatureReq) {
		
		LoginDto login = loginStatusDao.getStatus();
		if(!login.isLogin())
			throw new NotLoginException(NotLoginException.MSG);
		
		FeatureDto feature = hotelFeatureDaoInner.queryByName(checkNewFeatureReq.getName());
		List<NewFeatureDto> newFeatures = newFeatureDaoInner.findByNameAndHotelId(checkNewFeatureReq.getName(), login.getHotelId());
		
		boolean pass = (feature==null && newFeatures.size()==0);
		
		return CheckNewFeatureRespDto.builder()
				.pass(pass)
				.msg(pass ? "" : ILLEGAL_MSG)
				.build();
	}
}

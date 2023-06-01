package springboot.service.bk.hotelInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureReqDto;
import springboot.bean.dto.bk.hotelInfo.vo.checkNewHotelFeature.CheckNewHotelFeatureRespDto;
import springboot.bean.dto.model.HotelFeatureDto;
import springboot.dao.model.inner.HotelFeatureDaoInner;

@Service("bk.hotelInfo.CheckNewHotelFeatureService")
public class CheckNewHotelFeatureService {

	private static final String ILLEGAL_MSG = "名稱重複";
	@Autowired
	@Qualifier("model.inner.HotelFeatureDaoInner")
	private HotelFeatureDaoInner hotelFeatureDaoInner;
	
	
	public CheckNewHotelFeatureRespDto checkNewHotelFeature(CheckNewHotelFeatureReqDto checkNewHotelFeatureReq) {
		
		HotelFeatureDto hotelFeatureDto = hotelFeatureDaoInner.queryByName(checkNewHotelFeatureReq.getName());
	
		boolean pass = hotelFeatureDto==null;
		
		return CheckNewHotelFeatureRespDto.builder()
				.pass(pass)
				.msg(pass ? "" : ILLEGAL_MSG)
				.build();
	}
}

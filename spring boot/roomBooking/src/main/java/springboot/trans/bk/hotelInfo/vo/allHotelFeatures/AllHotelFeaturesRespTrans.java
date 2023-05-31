package springboot.trans.bk.hotelInfo.vo.allHotelFeatures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.allHotelFeatures.AllHotelFeaturesRespDto;
import springboot.bean.vo.bk.hotelInfo.allHotelFeatures.AllHotelFeaturesResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.hotelInfo.vo.allHotelFeatures.AllHotelFeaturesRespTrans")
public class AllHotelFeaturesRespTrans implements VoWoTrans<AllHotelFeaturesResp, AllHotelFeaturesRespDto> {

	@Autowired
	@Qualifier("bk.hotelInfo.vo.allHotelFeatures.HotelFeatureTrans")
	private HotelFeatureTrans hotelFeatureTrans;
	
	@Override
	public AllHotelFeaturesResp dtoToVoImpl(AllHotelFeaturesRespDto dto) {
		
		return AllHotelFeaturesResp.builder()
				.hotelFeatures(hotelFeatureTrans.dtoListToVoList(dto.getHotelFeatures()))
				.build();
	}
}

package springboot.trans.fr.hotelPage.vo.getInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.getInfo.GetInfoRespDto;
import springboot.bean.vo.fr.hotelPage.getInfo.Feature;
import springboot.bean.vo.fr.hotelPage.getInfo.GetInfoResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.getInfo.GetInfoRespTrans")
public class GetInfoRespTrans implements VoWoTrans<GetInfoResp, GetInfoRespDto> {

	@Autowired
	@Qualifier("fr.hotelPage.vo.getInfo.FeatureTrans")
	private FeatureTrans featureTrans;
	
	@Override
	public GetInfoResp dtoToVoImpl(GetInfoRespDto dto) {
		
		return GetInfoResp.builder()
				.imgUrl(dto.getImgUrl())
				.hotelName(dto.getHotelName())
				.address(dto.getAddress())
				.description(dto.getDescription())
			    .features(featureTrans.dtoListToVoArray(dto.getFeatures(), size -> new Feature[size]))
				.build();
	}
}

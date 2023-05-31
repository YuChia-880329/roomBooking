package springboot.trans.bk.hotelInfo.vo.allHotelFeatures;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.allHotelFeatures.HotelFeatureDto;
import springboot.bean.vo.bk.hotelInfo.allHotelFeatures.HotelFeature;
import tmpl.trans.bean.vo.VoWoTrans;


@Component("bk.hotelInfo.vo.allHotelFeatures.HotelFeatureTrans")
public class HotelFeatureTrans implements VoWoTrans<HotelFeature, HotelFeatureDto> {

	@Override
	public HotelFeature dtoToVoImpl(HotelFeatureDto dto) {
		
		return HotelFeature.builder()
				.id(dto.getId())
				.name(dto.getName())
				.checked(dto.isChecked())
				.build();
	}
}

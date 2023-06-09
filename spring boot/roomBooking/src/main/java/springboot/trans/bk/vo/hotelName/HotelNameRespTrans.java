package springboot.trans.bk.vo.hotelName;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.vo.hotelName.HotelNameRespDto;
import springboot.bean.vo.bk.hotelName.HotelNameResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.vo.hotelName.HotelNameRespTrans")
public class HotelNameRespTrans implements VoWoTrans<HotelNameResp, HotelNameRespDto> {

	@Override
	public HotelNameResp dtoToVoImpl(HotelNameRespDto dto) {
		
		return HotelNameResp.builder()
				.hotelName(dto.getHotelName())
				.build();
	}
}

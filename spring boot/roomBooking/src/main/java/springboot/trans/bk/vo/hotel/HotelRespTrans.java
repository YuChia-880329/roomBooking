package springboot.trans.bk.vo.hotel;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.vo.hotel.HotelRespDto;
import springboot.bean.vo.bk.hotel.HotelResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.vo.hotel.HotelRespTrans")
public class HotelRespTrans implements VoWoTrans<HotelResp, HotelRespDto> {

	@Override
	public HotelResp dtoToVoImpl(HotelRespDto dto) {
		
		return HotelResp.builder()
				.hotelId(dto.getHotelId())
				.hotelName(dto.getHotelName())
				.build();
	}
}

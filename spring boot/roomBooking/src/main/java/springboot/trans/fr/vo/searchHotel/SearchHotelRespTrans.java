package springboot.trans.fr.vo.searchHotel;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.vo.searchHotel.SearchHotelRespDto;
import springboot.bean.vo.fr.searchHotel.SearchHotelResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.vo.searchHotel.SearchHotelRespTrans")
public class SearchHotelRespTrans implements VoWoTrans<SearchHotelResp, SearchHotelRespDto> {

	@Override
	public SearchHotelResp dtoToVoImpl(SearchHotelRespDto dto) {
		
		return SearchHotelResp.builder()
				.hotelId(dto.getHotelId())
				.hasHotel(dto.isHasHotel())
				.msg(dto.getMsg())
				.build();
	}
}

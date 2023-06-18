package springboot.service.fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.vo.searchHotel.SearchHotelReqDto;
import springboot.bean.dto.fr.vo.searchHotel.SearchHotelRespDto;
import springboot.bean.dto.model.HotelDto;
import springboot.dao.model.inner.HotelDaoInner;

@Service("fr.SearchHotelService")
public class SearchHotelService {

	public static final String SUCCESS_MSG = "搜尋成功";
	public static final String FAILURE_MSG = "沒有此名稱的飯店";
	
	
	@Autowired
	@Qualifier("model.inner.HotelDaoInner")
	private HotelDaoInner hotelDaoInner;
	
	
	public SearchHotelRespDto searchHotel(SearchHotelReqDto searchHotelReq) {
		
		HotelDto hotel = hotelDaoInner.findByName(searchHotelReq.getName());
		
		boolean hasHotel = true;
		if(hotel == null)
			hasHotel = false;
		
		return SearchHotelRespDto.builder()
				.hotelId(hasHotel ? hotel.getId() : -1)
				.hasHotel(hasHotel)
				.msg(hasHotel ? SUCCESS_MSG : FAILURE_MSG)
				.build();
	}
}

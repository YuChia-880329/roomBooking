package springboot.service.fr.home;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.InputDto;
import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.OutputDto;
import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.SearchParamDto;
import springboot.bean.dto.fr.home.vo.search.HotelRoomDto;
import springboot.bean.dto.fr.home.vo.search.SearchReqDto;
import springboot.bean.dto.fr.home.vo.search.SearchRespDto;
import springboot.dao.fr.home.memory.repo.HotelRoomPagesDao;
import springboot.memory.repo.fr.home.HotelRoomPagesRepo;
import springboot.service.PaginationService;
import util.ImageUtil;

@Service("fr.home.SearchService")
public class SearchService {

	@Autowired
	@Qualifier("fr.home.memory.repo.HotelRoomPagesDao")
	private HotelRoomPagesDao hotelRoomPagesDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	public SearchRespDto search(SearchReqDto searchReq) {
		
		OutputDto output = hotelRoomPagesDao.getObj(toInputObj(searchReq));
		
		return SearchRespDto.builder()
				.hotels(toHotelRoomsVo(output))
				.pagination(paginationService.getPagination(output.getHotelRoomPage().getPage(), 
						HotelRoomPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
	
	private InputDto toInputObj(SearchReqDto searchReq) {
		
		return InputDto.builder()
				.searchParam(toSearchParamObj(searchReq))
				.build();
	}
	private SearchParamDto toSearchParamObj(SearchReqDto searchReq) {
		
		return SearchParamDto.builder()
				.page(1)
				.checkinDate(searchReq.getCheckinDate())
				.checkoutDate(searchReq.getCheckoutDate())
				.num(searchReq.getNum())
				.sectionCode(searchReq.getSectionCode())
				.build();
	}
	
	private List<HotelRoomDto> toHotelRoomsVo(OutputDto output){
		
		return toHotelRoomVos(output.getHotelRoomPage().getHotelRoomList().getHotelRooms());
	}
	private List<HotelRoomDto> toHotelRoomVos(List<springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.HotelRoomDto> hotelRooms){
		
		return hotelRooms.stream()
				.map(hotelRoom -> toHotelRoomVo(hotelRoom))
				.collect(Collectors.toList());
	}
	private HotelRoomDto toHotelRoomVo(springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.HotelRoomDto hotelRoom) {
		
		return HotelRoomDto.builder()
				.roomId(hotelRoom.getRoomId())
				.imgUrl(ImageUtil.getImgUrl(hotelRoom.getHotelId(), hotelRoom.getRoomId(), hotelRoom.getImgName()))
				.hotelName(hotelRoom.getHotelName())
				.sectionName(hotelRoom.getSectionName())
				.roomName(hotelRoom.getRoomName())
				.validNum(hotelRoom.getValidNum())
				.price(hotelRoom.getPrice())
				.hotelId(hotelRoom.getHotelId())
				.build();
	}
}

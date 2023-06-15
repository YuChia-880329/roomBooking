package springboot.service.fr.hotelPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.InputDto;
import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.OutputDto;
import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.SearchParamDto;
import springboot.bean.dto.fr.hotelPage.vo.search.SearchReqDto;
import springboot.bean.dto.fr.hotelPage.vo.search.SearchRespDto;
import springboot.dao.fr.hotelPage.memory.repo.RoomPagesDao;
import springboot.memory.repo.fr.hotelPage.RoomPagesRepo;
import springboot.service.PaginationService;

@Service("fr.hotelPage.SearchService")
public class SearchService {

	@Autowired
	@Qualifier("fr.hotelPage.memory.repo.RoomPagesDao")
	private RoomPagesDao roomPagesDao;
	@Autowired
	@Qualifier("fr.hotelPage.RepoService")
	private RepoService repoService;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	public SearchRespDto search(SearchReqDto searchReq) {
		
		OutputDto output = roomPagesDao.getObj(toInputObj(searchReq));
		return SearchRespDto.builder()
				.rooms(repoService.toRoomVos(output.getRoomPage().getRoomList().getRooms(), searchReq.getHotelId()))
				.pagination(paginationService.getPagination(output.getRoomPage().getPage(), 
						RoomPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
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
				.hotelId(searchReq.getHotelId())
				.checkinDate(searchReq.getCheckinDate())
				.checkoutDate(searchReq.getCheckoutDate())
				.num(searchReq.getNum())
				.build();
	}
	

}

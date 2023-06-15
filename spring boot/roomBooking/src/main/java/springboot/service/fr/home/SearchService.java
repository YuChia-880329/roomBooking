package springboot.service.fr.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.InputDto;
import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.OutputDto;
import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.SearchParamDto;
import springboot.bean.dto.fr.home.vo.search.SearchReqDto;
import springboot.bean.dto.fr.home.vo.search.SearchRespDto;
import springboot.dao.fr.home.memory.repo.HotelRoomPagesDao;
import springboot.memory.repo.fr.home.HotelRoomPagesRepo;
import springboot.service.PaginationService;

@Service("fr.home.SearchService")
public class SearchService {

	@Autowired
	@Qualifier("fr.home.memory.repo.HotelRoomPagesDao")
	private HotelRoomPagesDao hotelRoomPagesDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	@Autowired
	@Qualifier("fr.home.RepoService")
	private RepoService repoService;
	
	
	public SearchRespDto search(SearchReqDto searchReq) {
		
		OutputDto output = hotelRoomPagesDao.getObj(toInputObj(searchReq));
		
		return SearchRespDto.builder()
				.hotels(repoService.toHotelRoomsVo(output))
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
}

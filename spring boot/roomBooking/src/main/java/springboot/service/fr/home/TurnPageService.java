package springboot.service.fr.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.InputDto;
import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.OutputDto;
import springboot.bean.dto.fr.home.vo.turnPage.TurnPageReqDto;
import springboot.bean.dto.fr.home.vo.turnPage.TurnPageRespDto;
import springboot.dao.fr.home.memory.repo.HotelRoomPagesDao;
import springboot.memory.repo.fr.home.HotelRoomPagesRepo;
import springboot.service.PaginationService;

@Service("fr.home.TurnPageService")
public class TurnPageService {

	@Autowired
	@Qualifier("fr.home.memory.repo.HotelRoomPagesDao")
	private HotelRoomPagesDao hotelRoomPagesDao;
	@Autowired
	@Qualifier("fr.home.RepoService")
	private RepoService repoService;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	public TurnPageRespDto turnPage(TurnPageReqDto turnPageReq) {
		
		InputDto input = hotelRoomPagesDao.getLastInput();
		input.getSearchParam().setPage(turnPageReq.getPage());
		OutputDto output = hotelRoomPagesDao.getObj(input);
		
		return TurnPageRespDto.builder()
				.hotels(repoService.toHotelRoomsVo(output))
				.pagination(paginationService.getPagination(output.getHotelRoomPage().getPage(), 
						HotelRoomPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}

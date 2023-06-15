package springboot.service.fr.hotelPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.InputDto;
import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.OutputDto;
import springboot.bean.dto.fr.hotelPage.vo.turnPage.TurnPageReqDto;
import springboot.bean.dto.fr.hotelPage.vo.turnPage.TurnPageRespDto;
import springboot.dao.fr.hotelPage.memory.repo.RoomPagesDao;
import springboot.memory.repo.fr.hotelPage.RoomPagesRepo;
import springboot.service.PaginationService;

@Service("fr.hotelPage.TurnPageService")
public class TurnPageService {

	@Autowired
	@Qualifier("fr.hotelPage.memory.repo.RoomPagesDao")
	private RoomPagesDao roomPagesDao;
	@Autowired
	@Qualifier("fr.hotelPage.RepoService")
	private RepoService repoService;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	public TurnPageRespDto turnPage(TurnPageReqDto turnPageReq) {
		
		InputDto input = roomPagesDao.getLastInput();
		input.getSearchParam().setPage(turnPageReq.getPage());
		OutputDto output = roomPagesDao.getObj(input);
		
		return TurnPageRespDto.builder()
				.rooms(repoService.toRoomVos(output.getRoomPage().getRoomList().getRooms(), input.getSearchParam().getHotelId()))
				.pagination(paginationService.getPagination(output.getRoomPage().getPage(), 
						RoomPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}

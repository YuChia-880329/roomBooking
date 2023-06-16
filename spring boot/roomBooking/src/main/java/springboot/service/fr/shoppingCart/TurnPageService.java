package springboot.service.fr.shoppingCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.InputDto;
import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.OutputDto;
import springboot.bean.dto.fr.shoppingCart.vo.turnPage.TurnPageReqDto;
import springboot.bean.dto.fr.shoppingCart.vo.turnPage.TurnPageRespDto;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;
import springboot.dao.fr.shoppingCart.memory.repo.ItemPagesRepoDao;
import springboot.memory.repo.fr.hotelPage.RoomPagesRepo;
import springboot.service.PaginationService;

@Service("fr.shoppingCart.TurnPageService")
public class TurnPageService {

	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao shoppingCartDbDao;
	@Autowired
	@Qualifier("fr.shoppingCart.RepoService")
	private RepoService repoService;
	@Autowired
	@Qualifier("fr.shoppingCart.memory.repo.ItemPagesRepoDao")
	private ItemPagesRepoDao itemPagesRepoDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	public TurnPageRespDto turnPage(TurnPageReqDto turnPageReq) {
		
		List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items = shoppingCartDbDao.searchAll();
		InputDto input = repoService.toInputObj(items);
		input.getSearchParam().setPage(turnPageReq.getPage());
		OutputDto output = itemPagesRepoDao.getObj(input);
		
		return TurnPageRespDto.builder()
				.itemList(repoService.toItemListVo(output.getItemPage().getItemList()))
				.totalPrice(repoService.toTotalPrice(items))
				.pagination(paginationService.getPagination(output.getItemPage().getPage(), 
						RoomPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}

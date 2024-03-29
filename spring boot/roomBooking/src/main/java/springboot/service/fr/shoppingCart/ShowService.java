package springboot.service.fr.shoppingCart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.OutputDto;
import springboot.bean.dto.fr.shoppingCart.vo.show.ShowRespDto;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;
import springboot.dao.fr.shoppingCart.memory.repo.ItemPagesRepoDao;
import springboot.memory.repo.fr.shoppingCart.ItemPagesRepo;
import springboot.service.PaginationService;

@Service("fr.shoppingCart.ShowService")
public class ShowService {

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
	
	
	
	public ShowRespDto show() {
		
		List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items = shoppingCartDbDao.searchAll();
		OutputDto output = itemPagesRepoDao.getObj(repoService.toInputObj(items));
		
		return ShowRespDto.builder()
				.itemList(repoService.toItemListVo(output.getItemPage().getItemList()))
				.totalPrice(repoService.toTotalPrice(items))
				.pagination(paginationService.getPagination(output.getItemPage().getPage(), 
						ItemPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
}

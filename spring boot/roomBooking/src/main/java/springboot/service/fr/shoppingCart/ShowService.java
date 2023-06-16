package springboot.service.fr.shoppingCart;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.InputDto;
import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemIndexDto;
import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.OutputDto;
import springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.SearchParamDto;
import springboot.bean.dto.fr.shoppingCart.vo.ImageDto;
import springboot.bean.dto.fr.shoppingCart.vo.ItemDto;
import springboot.bean.dto.fr.shoppingCart.vo.ItemListDto;
import springboot.bean.dto.fr.shoppingCart.vo.show.ShowRespDto;
import springboot.dao.fr.memory.db.ShoppingCartDbDao;
import springboot.dao.fr.shoppingCart.memory.repo.ItemPagesRepoDao;
import springboot.memory.repo.fr.hotelPage.RoomPagesRepo;
import springboot.service.PaginationService;
import util.ImageUtil;

@Service("fr.shoppingCart.ShowService")
public class ShowService {

	@Autowired
	@Qualifier("fr.memory.db.ShoppingCartDbDao")
	private ShoppingCartDbDao shoppingCartDbDao;
	@Autowired
	@Qualifier("fr.shoppingCart.memory.repo.ItemPagesRepoDao")
	private ItemPagesRepoDao itemPagesRepoDao;
	@Autowired
	@Qualifier("PaginationService")
	private PaginationService paginationService;
	
	
	
	public ShowRespDto show() {
		
		List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items = shoppingCartDbDao.searchAll();
		OutputDto output = itemPagesRepoDao.getObj(toInputObj(items));
		
		return ShowRespDto.builder()
				.itemList(toItemListVo(items, output.getItemPage().getItemList()))
				.totalPrice(toTotalPrice(items))
				.pagination(paginationService.getPagination(output.getItemPage().getPage(), 
						RoomPagesRepo.PAGES_PER_PAGE_GROUP, output.getMaxPage()))
				.build();
	}
	
	private InputDto toInputObj(List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items) {
		
		return InputDto.builder()
				.searchParam(toSearchParamObj(items))
				.build();
	}
	private SearchParamDto toSearchParamObj(List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items) {
		
		return SearchParamDto.builder()
				.page(1)
				.itemIndices(toItemIndicesObj(items))
				.build();
	}
	private List<ItemIndexDto> toItemIndicesObj(List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items){
		
		return items.stream()
				.map(item -> toItemIndexObj(item))
				.collect(Collectors.toList());
	}
	private ItemIndexDto toItemIndexObj(springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto item) {
		
		return ItemIndexDto.builder()
				.itemId(item.getItemId())
				.roomId(item.getRoomId())
				.build();
	}
	
	private ItemListDto toItemListVo(List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items, springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemListDto itemList) {

		return ItemListDto.builder()
				.items(toItemVos(items, itemList.getItems()))
				.build();
	}
	private List<ItemDto> toItemVos(List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> itemsDb, List<springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemDto> itemsRepo){
		
		return itemsDb.stream()
				.map(itemDb -> {
			
					springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemDto itemRepo = null;
					for(int i=0; i<itemsRepo.size(); i++) {
						
						if(itemsRepo.get(i).getItemId() == itemDb.getItemId()) {
							
							itemRepo = itemsRepo.get(i);
							break;
						}
					}
					return toItemVo(itemDb, itemRepo);
				}).collect(Collectors.toList());
	}
	private ItemDto toItemVo(springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto itemDb, springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ItemDto itemRepo) {

		return ItemDto.builder()
				.itemId(itemDb.getItemId())
				.images(toImageVos(itemRepo.getImages(), itemRepo.getHotelId(), itemDb.getRoomId()))
				.hotelName(itemRepo.getHotelName())
				.roomName(itemRepo.getRoomName())
				.num(itemDb.getNum())
				.checkinDate(itemDb.getCheckinDate())
				.checkoutDate(itemDb.getCheckoutDate())
				.checkinTime(itemDb.getCheckinTime())
				.price(itemDb.getPrice())
				.build();
	}
	private List<ImageDto> toImageVos(List<springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ImageDto> images, int hotelId, int roomId){
		
		class MyInt{
			int index = 1;
		}
		MyInt myInt = new MyInt();
		
		return images.stream()
				.map(image -> toImageVo(image, hotelId, roomId, myInt.index++))
				.collect(Collectors.toList());
	}
	private ImageDto toImageVo(springboot.bean.dto.fr.shoppingCart.obj.repo.itemPages.ImageDto image, int hotelId, int roomId, int id) {
		
		return ImageDto.builder()
				.id(id)
				.imgUrl(ImageUtil.getImgUrl(hotelId, roomId, image.getImgName()))
				.build();
	}
	
	private int toTotalPrice(List<springboot.bean.dto.fr.obj.db.shoppingCart.ItemDto> items) {
		
		return items.stream().collect(Collectors.summingInt(item -> item.getNum()*item.getPrice()));
	}
}

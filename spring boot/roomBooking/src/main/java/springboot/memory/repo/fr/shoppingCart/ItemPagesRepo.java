package springboot.memory.repo.fr.shoppingCart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.model.RoomDto;
import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Image;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Input;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Item;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemIndex;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemList;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemPage;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.ItemPages;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.Output;
import springboot.bean.obj.fr.shoppingCart.repo.itemPages.SearchParam;
import springboot.dao.model.inner.RoomDaoInner;
import springboot.exception.IllegalPageException;
import springboot.memory.repo.Repo;
import springboot.service.fr.shoppingCart.memory.repo.itemPages.SearchParamService;
import util.PageUtil;

@Component("fr.shoppingCart.ItemPagesRepo")
@SessionScope
public class ItemPagesRepo extends Repo<Input, ItemPages, Output> {

	public static final int ROWS_PER_PAGE = 3;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	@Autowired
	@Qualifier("fr.shoppingCart.memory.repo.itemPages.SearchParamService")
	private SearchParamService searchParamService;
	@Autowired
	@Qualifier("model.inner.RoomDaoInner")
	private RoomDaoInner roomDaoInner;
	
	private boolean needUpdate;
	
	
	public ItemPagesRepo() {
		
		this.needUpdate = false;
	}
	
	public void needUpdate() {
		
		this.needUpdate = true;
	}
	
	@Override
	protected Input initialInput() {
		
		return Input.builder()
				.searchParam(SearchParam.builder()
						.page(-1)
						.itemIndices(new ArrayList<>())
						.build())
				.build();
	}

	@Override
	protected boolean isNeedUpdate(Input input) {
		
		return needUpdate ||
				!searchParamService.equals(input.getSearchParam(), lastInput.getSearchParam()) || 
				storeObj.getItemPageMap().get(input.getSearchParam().getPage()) == null;
	}

	@Override
	protected ItemPages update(Input input) {
		
		SearchParam searchParam = input.getSearchParam();
		if(needDefault(searchParam))
			return getDefault();
		
		
		int page = searchParam.getPage();

		int totalRows = searchParam.getItemIndices().size();
		
		int maxPage = PageUtil.countMaxPage(ROWS_PER_PAGE, totalRows);
		int[] pageBounds = PageUtil.countPage(page, PAGES_PER_PAGE_GROUP, maxPage);
		
		if(pageBounds == null)
			throw new IllegalPageException(IllegalPageException.MSG);
		
		Map<Integer, ItemPage> itemPageMap = new HashMap<>();
		for(int p=pageBounds[0]; p<= pageBounds[1]; p++) {
			
			int[] rowBounds = PageUtil.countRow(ROWS_PER_PAGE, p);
			
			List<ItemIndex> pageItemIndices = searchParam.getItemIndices().stream()
					.skip(rowBounds[0]-1)
					.limit(ROWS_PER_PAGE)
					.collect(Collectors.toList());
			List<Integer> roomIds = pageItemIndices.stream()
					.map(itemIndex -> itemIndex.getRoomId())
					.collect(Collectors.toList());
			
			List<RoomDto> rooms = roomDaoInner.queryFrItemPages(roomIds);
			
			itemPageMap.put(p, toItemPage(pageItemIndices, rooms, p));
		}
		
		if(needUpdate)
			needUpdate = false;
		
		return ItemPages.builder()
				.maxPage(maxPage)
				.itemPageMap(itemPageMap)
				.build();
	}

	@Override
	protected Output getOutput(Input input) {
		
		return Output.builder()
				.maxPage(storeObj.getMaxPage())
				.itemPage(storeObj.getItemPageMap().get(input.getSearchParam().getPage()))
				.build();
	}
	
	private ItemPage toItemPage(List<ItemIndex> itemIndices, List<RoomDto> rooms, int page) {
		
		return ItemPage.builder()
				.page(page)
				.itemList(toItemList(itemIndices, rooms))
				.build();
	}
	private ItemList toItemList(List<ItemIndex> itemIndices, List<RoomDto> rooms) {
		
		return ItemList.builder()
				.items(toItems(itemIndices, rooms))
				.build();
	}
	private List<Item> toItems(List<ItemIndex> itemIndices, List<RoomDto> rooms){
		
		return itemIndices.stream()
				.map(itemIndex -> toItem(itemIndex, rooms))
				.collect(Collectors.toList());
	}
	private Item toItem(ItemIndex itemIndex, List<RoomDto> rooms){
		
		RoomDto room = null;
		for(int i=0; i<rooms.size(); i++) {
			
			if(rooms.get(i).getId() == itemIndex.getRoomId()) {
				
				room = rooms.get(i);
				break;
			}	
		}
		
		return Item.builder()
				.itemId(itemIndex.getItemId())
				.images(toImages(room.getRoomImgs()))
				.hotelName(room.getHotel().getName())
				.roomName(room.getName())
				.hotelId(room.getHotelId())
				.build();
	}
	private List<Image> toImages(List<RoomImgDto> roomImgs){
		
		return roomImgs.stream()
				.map(roomImg -> toImage(roomImg))
				.collect(Collectors.toList());
	}
	private Image toImage(RoomImgDto roomImg) {
		
		return Image.builder()
				.imgName(roomImg.getImageName())
				.build();
	}
	
	
	private boolean needDefault(SearchParam searchParam) {
		
		return searchParam.getPage()<0 ||
				searchParam.getItemIndices().size()==0;
	}
	private ItemPages getDefault() {
		
		Map<Integer, ItemPage> itemPageMap = new HashMap<>();
		
		itemPageMap.put(1, ItemPage.builder()
				.itemList(ItemList.builder()
						.items(new ArrayList<>())
						.build())
				.page(1)
				.build());
		return ItemPages.builder()
				.maxPage(1)
				.itemPageMap(itemPageMap)
				.build();
	}
}

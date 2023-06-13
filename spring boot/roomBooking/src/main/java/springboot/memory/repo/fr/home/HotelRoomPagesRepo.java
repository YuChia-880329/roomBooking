package springboot.memory.repo.fr.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomList;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomPage;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.HotelRoomPages;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Input;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Output;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.SearchParam;
import springboot.memory.repo.Repo;
import springboot.service.fr.home.memory.repo.hotelRoomPages.SearchParamService;

@Component("fr.home.HotelRoomPagesRepo")
@SessionScope
public class HotelRoomPagesRepo extends Repo<Input, HotelRoomPages, Output> {

	public static final int ROWS_PER_PAGE = 10;
	public static final int PAGES_PER_PAGE_GROUP = 3;
	
	@Autowired
	@Qualifier("fr.home.memory.repo.hotelRoomPages.SearchParamService")
	private SearchParamService searchParamService;
	
	private boolean needUpdate;
	
	
	public HotelRoomPagesRepo() {
		
		this.needUpdate = false;
	}
	
	public void needUpdate() {
		
		this.needUpdate = true;
	}

	@Override
	protected Input initialInput() {
		
		SearchParam searchParam = SearchParam.builder()
				.page(1)
				.checkinDate(null)
				.checkoutDate(null)
				.num(null)
				.sectionCode(null)
				.build();
		return Input.builder()
				.searchParam(searchParam)
				.build();
	}

	@Override
	protected boolean isNeedUpdate(Input input) {
		
		return needUpdate ||
				!searchParamService.equals(input.getSearchParam(), lastInput.getSearchParam()) || 
				storeObj.getHotelRoomPageMap().get(input.getSearchParam().getPage()) == null;
	}

	@Override
	protected HotelRoomPages update(Input input) {
		
		
		Map<Integer, HotelRoomPage> map = new HashMap<>();
		map.put(1, HotelRoomPage.builder()
				.page(1)
				.hotelRoomList(HotelRoomList.builder()
						.hotelRooms(new ArrayList<>())
						.build())
				.build());
		return HotelRoomPages.builder()
				.maxPage(0)
				.hotelRoomPageMap(map)
				.build();
	}

	@Override
	protected Output getOutput(Input input) {
		
		return Output.builder()
				.maxPage(storeObj.getMaxPage())
				.hotelRoomPage(storeObj.getHotelRoomPageMap().get(input.getSearchParam().getPage()))
				.build();
	}
}

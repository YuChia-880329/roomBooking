package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.RoomTableRowsDto;
import springboot.bean.vo.bk.roomList.ri.SearchTableSearchParam;
import springboot.trans.bk.roomList.vo.ri.SearchTableSearchParamTrans;

@Service
public class RoomListControllerService {

	@Autowired
	private SearchTableService searchTableService;
	@Autowired
	private SearchTableSearchParamTrans searchTableSearchParamTrans;
	
	
	public RoomTableRowsDto searchTable(String page, String name, String totalNumMin, String totalNumMax, 
			String usedNumMin, String usedNumMax, String invalidNumMin, String invalidNumMax,
			String priceMin, String priceMax, String order) {
		
		SearchTableSearchParam searchTableSearchParam = SearchTableSearchParam.builder()
				.page(page)
				.name(name)
				.totalNumMin(totalNumMin)
				.totalNumMax(totalNumMax)
				.usedNumMin(usedNumMin)
				.usedNumMax(usedNumMax)
				.invalidNumMin(invalidNumMin)
				.invalidNumMax(invalidNumMax)
				.priceMin(priceMin)
				.priceMax(priceMax)
				.order(order)
				.build();
		
		return searchTableService.searchTable(
				searchTableSearchParamTrans.voToDto(searchTableSearchParam));
	}
}

package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.InputDto;
import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.RoomTableRowsDto;
import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.SearchParamDto;
import springboot.bean.dto.bk.roomList.vo.ri.SearchTableSearchParamDto;
import springboot.dao.bk.roomList.memory.repo.RoomTableRowsRepoDAO;

@Service
public class SearchTableService {
	
	@Autowired
	private RoomTableRowsRepoDAO roomTableRowsRepoDAO;
	

	public RoomTableRowsDto searchTable(SearchTableSearchParamDto searchTableSearchParam) {
		
		RoomTableRowsDto roomTableRowsDto = roomTableRowsRepoDAO.getObjDto(InputDto.builder()
				.searchParam(toSearchParam(searchTableSearchParam))
				.build());
		
		return roomTableRowsDto;
	}
	
	private SearchParamDto toSearchParam(SearchTableSearchParamDto searchTableSearchParam) {
		
		return SearchParamDto.builder()
				.page(searchTableSearchParam.getPage())
				.totalNumMin(searchTableSearchParam.getTotalNumMin())
				.totalNumMax(searchTableSearchParam.getTotalNumMax())
				.usedNumMin(searchTableSearchParam.getUsedNumMin())
				.usedNumMax(searchTableSearchParam.getUsedNumMax())
				.invalidNumMin(searchTableSearchParam.getInvalidNumMin())
				.invalidNumMax(searchTableSearchParam.getInvalidNumMax())
				.priceMin(searchTableSearchParam.getPriceMin())
				.priceMax(searchTableSearchParam.getPriceMax())
				.roomTableOrder(searchTableSearchParam.getOrder())
				.build();
	}
}

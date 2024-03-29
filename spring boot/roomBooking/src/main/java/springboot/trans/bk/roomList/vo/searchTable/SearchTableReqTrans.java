package springboot.trans.bk.roomList.vo.searchTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import enumeration.RoomStatus;
import springboot.bean.dto.bk.roomList.vo.searchTable.SearchTableReqDto;
import springboot.bean.vo.bk.roomList.searchTable.SearchTableReq;
import springboot.checker.bk.roomList.vo.searchTable.SearchTableReqChecker;
import springboot.trans.VoRiTransChecked;

@Component("bk.roomList.vo.searchTable.SearchTableReqTrans")
public class SearchTableReqTrans extends VoRiTransChecked<SearchTableReq, SearchTableReqDto, SearchTableReqChecker> {
	
	@Override
	public SearchTableReqDto voToDtoImpl(SearchTableReq vo) {
		
		String totalNumMin = vo.getTotalNumMin();
		String totalNumMax = vo.getTotalNumMax();
		String invalidNumMin = vo.getInvalidNumMin();
		String invalidNumMax = vo.getInvalidNumMax();
		String priceMin = vo.getPriceMin();
		String priceMax = vo.getPriceMax();
		String status = vo.getStatus();
		
		return SearchTableReqDto.builder()
				.name(vo.getName())
				.totalNumMin(totalNumMin==null ? null : Integer.parseInt(totalNumMin))
				.totalNumMax(totalNumMax==null ? null : Integer.parseInt(totalNumMax))
				.invalidNumMin(invalidNumMin==null ? null : Integer.parseInt(invalidNumMin))
				.invalidNumMax(invalidNumMax==null ? null : Integer.parseInt(invalidNumMax))
				.priceMin(priceMin==null ? null : Integer.parseInt(priceMin))
				.priceMax(priceMax==null ? null : Integer.parseInt(priceMax))
				.status(status==null ? null : RoomStatus.getByCode(Integer.parseInt(status)))
				.build();
	}

	@Autowired
	@Override
	public void setChecker(SearchTableReqChecker checker) {
		
		this.checker = checker;
	}
}

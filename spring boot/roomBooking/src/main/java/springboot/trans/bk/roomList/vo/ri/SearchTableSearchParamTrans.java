package springboot.trans.bk.roomList.vo.ri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.dto.bk.roomList.vo.ri.SearchTableSearchParamDto;
import springboot.bean.vo.bk.roomList.ri.SearchTableSearchParam;
import springboot.checker.bk.roomList.vo.ri.SearchTableSearchParamChecker;
import springboot.trans.VoRiTransChecked;

@Component
public class SearchTableSearchParamTrans extends VoRiTransChecked<SearchTableSearchParam, SearchTableSearchParamDto, SearchTableSearchParamChecker> {

	@Override
	public SearchTableSearchParamDto voToDtoImpl(SearchTableSearchParam vo) {
		
		String page = vo.getPage();
		String totalNumMin = vo.getTotalNumMin();
		String totalNumMax = vo.getTotalNumMax();
		String usedNumMin = vo.getUsedNumMin();
		String usedNumMax = vo.getUsedNumMax();
		String invalidNumMin = vo.getInvalidNumMin();
		String invalidNumMax = vo.getInvalidNumMax();
		String priceMin = vo.getPriceMin();
		String priceMax = vo.getPriceMax();
		String order = vo.getOrder();
		
		return SearchTableSearchParamDto.builder()
				.page(page==null ? 1 : Integer.parseInt(page))
				.name(vo.getName())
				.totalNumMin(totalNumMin==null ? null : Integer.parseInt(totalNumMin))
				.totalNumMax(totalNumMax==null ? null : Integer.parseInt(totalNumMax))
				.usedNumMin(usedNumMin==null ? null : Integer.parseInt(usedNumMin))
				.usedNumMax(usedNumMax==null ? null : Integer.parseInt(usedNumMax))
				.invalidNumMin(invalidNumMin==null ? null : Integer.parseInt(invalidNumMin))
				.invalidNumMax(invalidNumMax==null ? null : Integer.parseInt(invalidNumMax))
				.priceMin(priceMin==null ? null : Integer.parseInt(priceMin))
				.priceMax(priceMax==null ? null : Integer.parseInt(priceMax))
				.order(order==null ? RoomTableOrder.NAME_ASC : RoomTableOrder.getByCode(Integer.parseInt(order)))
				.build();
	}

	@Autowired
	@Override
	public void setChecker(SearchTableSearchParamChecker checker) {
		
		this.checker = checker;
	}
}

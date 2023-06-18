package springboot.trans.bk.bookingOrderList.vo.searchTable;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.vo.searchTable.SearchTableReqDto;
import springboot.bean.vo.bk.bookingOrderList.searchTable.SearchTableReq;
import springboot.checker.bk.bookingOrderList.vo.searchTable.SearchTableReqChecker;
import springboot.trans.VoRiTransChecked;
import util.DateTimeUtil;

@Component("bk.bookingOrderList.vo.searchTable.SearchTableReqTrans")
public class SearchTableReqTrans extends VoRiTransChecked<SearchTableReq, SearchTableReqDto, SearchTableReqChecker> {
	
	@Override
	public SearchTableReqDto voToDtoImpl(SearchTableReq vo) {
		
		String idMin = vo.getIdMin();
		String idMax = vo.getIdMax();
		String roomType = vo.getRoomType();
		String roomNumMin = vo.getRoomNumMin();
		String roomNumMax = vo.getRoomNumMax();
		String priceMin = vo.getPriceMin();
		String priceMax = vo.getPriceMax();
		String[] payMethodIds = vo.getPayMethodIds();
		String checkinDateFrom = vo.getCheckinDateFrom();
		String checkinDateTo = vo.getCheckinDateTo();
		String checkoutDateFrom = vo.getCheckoutDateFrom();
		String checkoutDateTo = vo.getCheckoutDateTo();
		String useDayMin = vo.getUseDayMin();
		String useDayMax = vo.getUseDayMax();
		String totalPriceMin = vo.getTotalPriceMin();
		String totalPriceMax = vo.getTotalPriceMax();
		
		
		return SearchTableReqDto.builder()
				.idMin(idMin==null ? null : Integer.parseInt(idMin))
				.idMax(idMax==null ? null : Integer.parseInt(idMax))
				.clientName(vo.getClientName())
				.clientPhone(vo.getClientPhone())
				.roomType(roomType==null ? null : Integer.parseInt(roomType))
				.roomNumMin(roomNumMin==null ? null : Integer.parseInt(roomNumMin))
				.roomNumMax(roomNumMax==null ? null : Integer.parseInt(roomNumMax))
				.priceMin(priceMin==null ? null : Integer.parseInt(priceMin))
				.priceMax(priceMax==null ? null : Integer.parseInt(priceMax))
				.payMethodIds(payMethodIds==null ? null : Arrays.stream(payMethodIds)
						.map(payMethodId -> Integer.parseInt(payMethodId)).collect(Collectors.toList()))
				.checkinDateFrom(checkinDateFrom==null ? null : DateTimeUtil.toLocalDateFront(checkinDateFrom))
				.checkinDateTo(checkinDateTo==null ? null : DateTimeUtil.toLocalDateFront(checkinDateTo))
				.checkoutDateFrom(checkoutDateFrom==null ? null : DateTimeUtil.toLocalDateFront(checkoutDateFrom))
				.checkoutDateTo(checkoutDateTo==null ? null : DateTimeUtil.toLocalDateFront(checkoutDateTo))
				.useDayMin(useDayMin==null ? null : Integer.parseInt(useDayMin))
				.useDayMax(useDayMax==null ? null : Integer.parseInt(useDayMax))
				.totalPriceMin(totalPriceMin==null ? null : Integer.parseInt(totalPriceMin))
				.totalPriceMax(totalPriceMax==null ? null : Integer.parseInt(totalPriceMax))
				.build();
	}

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.searchTable.SearchTableReqChecker")
	@Override
	public void setChecker(SearchTableReqChecker checker) {
		
		this.checker = checker;
	}
}

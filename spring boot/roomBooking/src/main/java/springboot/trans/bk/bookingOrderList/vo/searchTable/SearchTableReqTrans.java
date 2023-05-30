package springboot.trans.bk.bookingOrderList.vo.searchTable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import enumeration.PayMethod;
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
		String roomNumMin = vo.getRoomNumMin();
		String roomNumMax = vo.getRoomNumMax();
		String priceMin = vo.getPriceMin();
		String priceMax = vo.getPriceMax();
		String[] payMethods = vo.getPayMethods();
		String checkinDateTimeFrom = vo.getCheckinDateTimeFrom();
		String checkinDateTimeTo = vo.getCheckinDateTimeTo();
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
				.roomName(vo.getRoomName())
				.roomNumMin(roomNumMin==null ? null : Integer.parseInt(roomNumMin))
				.roomNumMax(roomNumMax==null ? null : Integer.parseInt(roomNumMax))
				.priceMin(priceMin==null ? null : Integer.parseInt(priceMin))
				.priceMax(priceMax==null ? null : Integer.parseInt(priceMax))
				.payMethods(payMethods==null ? null : toPayMethods(payMethods))
				.checkinDateTimeFrom(checkinDateTimeFrom==null ? null : DateTimeUtil.toLocalDateTime(checkinDateTimeFrom))
				.checkinDateTimeTo(checkinDateTimeTo==null ? null : DateTimeUtil.toLocalDateTime(checkinDateTimeTo))
				.checkoutDateFrom(checkoutDateFrom==null ? null : DateTimeUtil.toLocalDate(checkoutDateFrom))
				.checkoutDateTo(checkoutDateTo==null ? null : DateTimeUtil.toLocalDate(checkoutDateTo))
				.useDayMin(useDayMin==null ? null : Integer.parseInt(useDayMin))
				.useDayMax(useDayMax==null ? null : Integer.parseInt(useDayMax))
				.totalPriceMin(totalPriceMin==null ? null : Integer.parseInt(totalPriceMin))
				.totalPriceMax(totalPriceMax==null ? null : Integer.parseInt(totalPriceMax))
				.build();
	}
	
	private PayMethod[] toPayMethods(String[] payMethods) {
		
		List<PayMethod> list = Arrays.stream(payMethods)
				.map(payMethod -> PayMethod.getById(Integer.parseInt(payMethod)))
				.collect(Collectors.toList());
		
		return list.toArray(new PayMethod[list.size()]);
	}

	@Autowired
	@Qualifier("bk.bookingOrderList.vo.searchTable.SearchTableReqChecker")
	@Override
	public void setChecker(SearchTableReqChecker checker) {
		
		this.checker = checker;
	}
}

package springboot.service.bk.bookingOrderList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.bookingOrderList.searchTable.SearchTableReq;
import springboot.trans.bk.bookingOrderList.vo.searchTable.SearchTableReqTrans;
import springboot.trans.bk.bookingOrderList.vo.searchTable.SearchTableRespTrans;
import util.ResponseUtil;

@Service("bk.bookingOrderList.BookingOrderListControllerService")
public class BookingOrderListControllerService {

	@Autowired
	@Qualifier("bk.bookingOrderList.SearchTableService")
	private SearchTableService searchTableService;
	
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.searchTable.SearchTableReqTrans")
	private SearchTableReqTrans searchTableReqTrans;
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.searchTable.SearchTableRespTrans")
	private SearchTableRespTrans searchTableRespTrans;
	
	
	public Response searchTable(String idMin, String idMax, String clientName, String clientPhone, 
			String roomName, String roomNumMin, String roomNumMax, String priceMin, String priceMax, 
			String[] payMethods, String checkinDateTimeFrom, String checkinDateTimeTo, String checkoutDateFrom, 
			String checkoutDateTo, String useDayMin, String useDayMax, String totalPriceMin, String totalPriceMax) {
		
		SearchTableReq searchTableReq = SearchTableReq.builder()
				.idMin(idMin)
				.idMax(idMax)
				.clientName(clientName)
				.clientPhone(clientPhone)
				.roomName(roomName)
				.roomNumMin(roomNumMin)
				.roomNumMax(roomNumMax)
				.priceMin(priceMin)
				.priceMax(priceMax)
				.payMethods(payMethods)
				.checkinDateTimeFrom(checkinDateTimeFrom)
				.checkinDateTimeTo(checkinDateTimeTo)
				.checkoutDateFrom(checkoutDateFrom)
				.checkoutDateTo(checkoutDateTo)
				.useDayMin(useDayMin)
				.useDayMax(useDayMax)
				.totalPriceMin(totalPriceMin)
				.totalPriceMax(totalPriceMax)
				.build();
		
		return ResponseUtil.response200(
				searchTableRespTrans.dtoToVo(
						searchTableService.searchTable(
								searchTableReqTrans.voToDto(searchTableReq))));
	}
	
}

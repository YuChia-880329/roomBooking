package springboot.service.bk.bookingOrderList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.bookingOrderList.changeOrder.ChangeOrderReq;
import springboot.bean.vo.bk.bookingOrderList.searchTable.SearchTableReq;
import springboot.bean.vo.bk.bookingOrderList.turnPage.TurnPageReq;
import springboot.trans.bk.bookingOrderList.vo.allPayMethods.AllPayMethodsRespTrans;
import springboot.trans.bk.bookingOrderList.vo.allRooms.AllRoomsRespTrans;
import springboot.trans.bk.bookingOrderList.vo.changeOrder.ChangeOrderReqTrans;
import springboot.trans.bk.bookingOrderList.vo.changeOrder.ChangeOrderRespTrans;
import springboot.trans.bk.bookingOrderList.vo.searchTable.SearchTableReqTrans;
import springboot.trans.bk.bookingOrderList.vo.searchTable.SearchTableRespTrans;
import springboot.trans.bk.bookingOrderList.vo.turnPage.TurnPageReqTrans;
import springboot.trans.bk.bookingOrderList.vo.turnPage.TurnPageRespTrans;
import util.ResponseUtil;

@Service("bk.bookingOrderList.BookingOrderListControllerService")
public class BookingOrderListControllerService {

	@Autowired
	@Qualifier("bk.bookingOrderList.AllRoomsService")
	private AllRoomsService allRoomsService;
	@Autowired
	@Qualifier("bk.bookingOrderList.SearchTableService")
	private SearchTableService searchTableService;
	@Autowired
	@Qualifier("bk.bookingOrderList.AllPayMethodsService")
	private AllPayMethodsService allPayMethodsService;
	@Autowired
	@Qualifier("bk.bookingOrderList.ChangeOrderService")
	private ChangeOrderService changeOrderService;
	@Autowired
	@Qualifier("bk.bookingOrderList.TurnPageService")
	private TurnPageService turnPageService;
	
	
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.searchTable.SearchTableReqTrans")
	private SearchTableReqTrans searchTableReqTrans;
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.searchTable.SearchTableRespTrans")
	private SearchTableRespTrans searchTableRespTrans;
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.allRooms.AllRoomsRespTrans")
	private AllRoomsRespTrans allRoomsRespTrans;
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.allPayMethods.AllPayMethodsRespTrans")
	private AllPayMethodsRespTrans allPayMethodsRespTrans;
	
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.turnPage.TurnPageReqTrans")
	private TurnPageReqTrans turnPageReqTrans;
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.turnPage.TurnPageRespTrans")
	private TurnPageRespTrans turnPageRespTrans;
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.changeOrder.ChangeOrderReqTrans")
	private ChangeOrderReqTrans changeOrderReqTrans;
	@Autowired
	@Qualifier("bk.bookingOrderList.vo.changeOrder.ChangeOrderRespTrans")
	private ChangeOrderRespTrans changeOrderRespTrans;
	
	
	public Response allRooms() {
		
		return ResponseUtil.response200(
				allRoomsRespTrans.dtoToVo(
						allRoomsService.allRooms()));
	}
	public Response allPayMethods() {
		
		return ResponseUtil.response200(
				allPayMethodsRespTrans.dtoToVo(
						allPayMethodsService.allPayMethods()));
	}
	public Response searchTable(String idMin, String idMax, String clientName, String clientPhone, 
			String roomType, String roomNumMin, String roomNumMax, String priceMin, String priceMax, 
			String[] payMethodIds, String checkinDateFrom, String checkinDateTo, String checkoutDateFrom, 
			String checkoutDateTo, String useDayMin, String useDayMax, String totalPriceMin, String totalPriceMax) {
		
		SearchTableReq searchTableReq = SearchTableReq.builder()
				.idMin(idMin)
				.idMax(idMax)
				.clientName(clientName)
				.clientPhone(clientPhone)
				.roomType(roomType)
				.roomNumMin(roomNumMin)
				.roomNumMax(roomNumMax)
				.priceMin(priceMin)
				.priceMax(priceMax)
				.payMethodIds(payMethodIds)
				.checkinDateFrom(checkinDateFrom)
				.checkinDateTo(checkinDateTo)
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
	
	
	public Response turnPage(String page) {
		
		TurnPageReq turnPageReq = TurnPageReq.builder()
				.page(page)
				.build();
		
		return ResponseUtil.response200(
				turnPageRespTrans.dtoToVo(
						turnPageService.turnPage(
								turnPageReqTrans.voToDto(turnPageReq))));
	}
	
	public Response changeOrder(String order) {
		
		ChangeOrderReq changeOrderReq = ChangeOrderReq.builder()
				.order(order)
				.build();
		
		return ResponseUtil.response200(
				changeOrderRespTrans.dtoToVo(
						changeOrderService.changeOrder(
								changeOrderReqTrans.voToDto(changeOrderReq))));
	}
	
}

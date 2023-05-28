package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.roomList.searchTable.SearchParam;
import springboot.bean.vo.bk.roomList.searchTable.SearchTableReq;
import springboot.bean.vo.bk.roomList.turnPage.TurnPageReq;
import springboot.trans.bk.roomList.vo.searchTable.SearchTableReqTrans;
import springboot.trans.bk.roomList.vo.searchTable.SearchTableRespTrans;
import springboot.trans.bk.roomList.vo.turnPage.TurnPageReqTrans;
import springboot.trans.bk.roomList.vo.turnPage.TurnPageRespTrans;
import util.ResponseUtil;

@Service("bk.roomList.RoomListControllerService")
public class RoomListControllerService {

	@Autowired
	@Qualifier("bk.roomList.SearchTableService")
	private SearchTableService searchTableService;
	@Autowired
	@Qualifier("bk.roomList.TurnPageService")
	private TurnPageService turnPageService;
	
	
	@Autowired
	@Qualifier("bk.roomList.vo.searchTable.SearchTableReqTrans")
	private SearchTableReqTrans searchTableReqTrans;
	@Autowired
	@Qualifier("bk.roomList.vo.searchTable.SearchTableRespTrans")
	private SearchTableRespTrans searchTableRespTrans;
	@Autowired
	@Qualifier("bk.roomList.vo.turnPage.TurnPageReqTrans")
	private TurnPageReqTrans turnPageReqTrans;
	@Autowired
	@Qualifier("bk.roomList.vo.turnPage.TurnPageRespTrans")
	private TurnPageRespTrans turnPageRespTrans;
	
	
	public Response searchTable(String name, String totalNumMin, String totalNumMax, 
			String usedNumMin, String usedNumMax, String invalidNumMin, String invalidNumMax,
			String priceMin, String priceMax) {
		
		SearchParam searchParam = SearchParam.builder()
				.name(name)
				.totalNumMin(totalNumMin)
				.totalNumMax(totalNumMax)
				.usedNumMin(usedNumMin)
				.usedNumMax(usedNumMax)
				.invalidNumMin(invalidNumMin)
				.invalidNumMax(invalidNumMax)
				.priceMin(priceMin)
				.priceMax(priceMax)
				.build();
		
		return ResponseUtil.response200(
				searchTableRespTrans.dtoToVo(
						searchTableService.searchTable(
								searchTableReqTrans.voToDto(SearchTableReq.builder()
										.searchParam(searchParam)
										.build()))));
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
}

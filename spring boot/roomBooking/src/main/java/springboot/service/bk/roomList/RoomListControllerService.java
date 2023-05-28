package springboot.service.bk.roomList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.bk.roomList.searchTable.SearchParam;
import springboot.bean.vo.bk.roomList.searchTable.SearchTableReq;
import springboot.trans.bk.roomList.vo.searchTable.SearchTableReqTrans;
import springboot.trans.bk.roomList.vo.searchTable.SearchTableRespTrans;
import util.ResponseUtil;

@Service
public class RoomListControllerService {

	@Autowired
	private SearchTableService searchTableService;
	
	
	@Autowired
	private SearchTableReqTrans searchTableReqTrans;
	@Autowired
	private SearchTableRespTrans searchTableRespTrans;
	
	
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
}

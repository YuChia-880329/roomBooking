package springboot.service.fr.hotelPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.hotelPage.getInfo.GetInfoReq;
import springboot.bean.vo.fr.hotelPage.search.SearchReq;
import springboot.trans.fr.hotelPage.vo.getInfo.GetInfoReqTrans;
import springboot.trans.fr.hotelPage.vo.getInfo.GetInfoRespTrans;
import springboot.trans.fr.hotelPage.vo.search.SearchReqTrans;
import springboot.trans.fr.hotelPage.vo.search.SearchRespTrans;
import util.ResponseUtil;

@Service("fr.hotelPage.HotelPageService")
public class HotelPageService {

	@Autowired
	@Qualifier("fr.hotelPage.GetInfoService")
	private GetInfoService getInfoService;
	@Autowired
	@Qualifier("fr.hotelPage.SearchService")
	private SearchService searchService;
	
	
	@Autowired
	@Qualifier("fr.hotelPage.vo.getInfo.GetInfoReqTrans")
	private GetInfoReqTrans getInfoReqTrans;
	@Autowired
	@Qualifier("fr.hotelPage.vo.getInfo.GetInfoRespTrans")
	private GetInfoRespTrans getInfoRespTrans;
	@Autowired
	@Qualifier("fr.hotelPage.vo.search.SearchReqTrans")
	private SearchReqTrans searchReqTrans;
	@Autowired
	@Qualifier("fr.hotelPage.vo.search.SearchRespTrans")
	private SearchRespTrans searchRespTrans;
	
	
	public Response getInfo(String hotelId) {
		
		GetInfoReq getInfoReq = GetInfoReq.builder()
				.hotelId(hotelId)
				.build();
		
		return ResponseUtil.response200(
				getInfoRespTrans.dtoToVo(
						getInfoService.getInfo(
								getInfoReqTrans.voToDto(getInfoReq))));
	}
	public Response search(String hotelId, String checkinDate, String checkoutDate, String numCode) {
		
		SearchReq searchReq = SearchReq.builder()
				.hotelId(hotelId)
				.checkinDate(checkinDate)
				.checkoutDate(checkoutDate)
				.numCode(numCode)
				.build();
		return ResponseUtil.response200(
				searchRespTrans.dtoToVo(
						searchService.search(
								searchReqTrans.voToDto(searchReq))));
	}
}

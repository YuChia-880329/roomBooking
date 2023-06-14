package springboot.service.fr.hotelPage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.hotelPage.getInfo.GetInfoReq;
import springboot.trans.fr.hotelPage.vo.getInfo.GetInfoReqTrans;
import springboot.trans.fr.hotelPage.vo.getInfo.GetInfoRespTrans;
import util.ResponseUtil;

@Service("fr.hotelPage.HotelPageService")
public class HotelPageService {

	@Autowired
	@Qualifier("fr.hotelPage.GetInfoService")
	private GetInfoService getInfoService;
	
	
	@Autowired
	@Qualifier("fr.hotelPage.vo.getInfo.GetInfoReqTrans")
	private GetInfoReqTrans getInfoReqTrans;
	@Autowired
	@Qualifier("fr.hotelPage.vo.getInfo.GetInfoRespTrans")
	private GetInfoRespTrans getInfoRespTrans;
	
	
	public Response getInfo(String hotelId) {
		
		GetInfoReq getInfoReq = GetInfoReq.builder()
				.hotelId(hotelId)
				.build();
		
		return ResponseUtil.response200(
				getInfoRespTrans.dtoToVo(
						getInfoService.getInfo(
								getInfoReqTrans.voToDto(getInfoReq))));
	}
}

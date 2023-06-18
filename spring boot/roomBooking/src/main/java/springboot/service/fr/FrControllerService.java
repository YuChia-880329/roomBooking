package springboot.service.fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.bean.vo.fr.searchHotel.SearchHotelReq;
import springboot.trans.fr.vo.checkLogin.CheckLoginRespTrans;
import springboot.trans.fr.vo.logout.LogoutRespTrans;
import springboot.trans.fr.vo.memberName.MemberNameRespTrans;
import springboot.trans.fr.vo.searchHotel.SearchHotelReqTrans;
import springboot.trans.fr.vo.searchHotel.SearchHotelRespTrans;
import util.ResponseUtil;

@Service("service.fr.FrControllerService")
public class FrControllerService {

	@Autowired
	@Qualifier("fr.CheckLoginService")
	private CheckLoginService checkLoginService;
	@Autowired
	@Qualifier("fr.LogoutService")
	private LogoutService logoutService;
	@Autowired
	@Qualifier("fr.SearchHotelService")
	private SearchHotelService searchHotelService;
	@Autowired
	@Qualifier("fr.MemberNameService")
	private MemberNameService memberNameService;
	
	
	@Autowired
	@Qualifier("fr.vo.checkLogin.CheckLoginRespTrans")
	private CheckLoginRespTrans checkLoginRespTrans;
	@Autowired
	@Qualifier("fr.vo.logout.LogoutRespTrans")
	private LogoutRespTrans logoutRespTrans;
	@Autowired
	@Qualifier("fr.vo.searchHotel.SearchHotelReqTrans")
	private SearchHotelReqTrans searchHotelReqTrans;
	@Autowired
	@Qualifier("fr.vo.searchHotel.SearchHotelRespTrans")
	private SearchHotelRespTrans searchHotelRespTrans;
	@Autowired
	@Qualifier("fr.vo.memberName.MemberNameRespTrans")
	private MemberNameRespTrans memberNameRespTrans;
	
	
	
	public Response checkLogin() {
		
		return ResponseUtil.response200(
				checkLoginRespTrans.dtoToVo(
						checkLoginService.checkLogin()));
	}
	public Response logout() {
		
		return ResponseUtil.response200(
				logoutRespTrans.dtoToVo(
						logoutService.logout()));
	}
	public Response searchHotel(String name) {
		
		SearchHotelReq searchHotelReq = SearchHotelReq.builder()
				.name(name)
				.build();
		
		return ResponseUtil.response200(
				searchHotelRespTrans.dtoToVo(
						searchHotelService.searchHotel(
								searchHotelReqTrans.voToDto(searchHotelReq))));
	}
	public Response memberName() {
		
		return ResponseUtil.response200(
				memberNameRespTrans.dtoToVo(memberNameService.memberName()));
	}
}

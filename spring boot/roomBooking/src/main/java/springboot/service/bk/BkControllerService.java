package springboot.service.bk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.trans.bk.vo.checkLogin.CheckLoginRespTrans;
import springboot.trans.bk.vo.hotel.HotelRespTrans;
import springboot.trans.bk.vo.logout.LogoutRespTrans;
import util.ResponseUtil;

@Service("bk.BkControllerService")
public class BkControllerService {

	@Autowired
	@Qualifier("bk.CheckLoginService")
	private CheckLoginService checkLoginService;
	@Autowired
	@Qualifier("bk.HotelService")
	private HotelService hotelService;
	@Autowired
	@Qualifier("bk.LogoutService")
	private LogoutService logoutService;
	
	
	@Autowired
	@Qualifier("bk.vo.checkLogin.CheckLoginRespTrans")
	private CheckLoginRespTrans checkLoginRespTrans;
	@Autowired
	@Qualifier("bk.vo.hotel.HotelRespTrans")
	private HotelRespTrans hotelRespTrans;
	@Autowired
	@Qualifier("bk.vo.logout.LogoutRespTrans")
	private LogoutRespTrans logoutRespTrans;
	
	
	
	public Response checkLogin() {
		
		return ResponseUtil.response200(
				checkLoginRespTrans.dtoToVo(
						checkLoginService.checkLogin()));
	}
	public Response hotel() {
		
		return ResponseUtil.response200(
				hotelRespTrans.dtoToVo(
						hotelService.hotelName()));
	}
	public Response logout() {
		
		return ResponseUtil.response200(
				logoutRespTrans.dtoToVo(
						logoutService.logout()));
	}
}

package springboot.service.bk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.trans.bk.vo.checkLogin.CheckLoginRespTrans;
import util.ResponseUtil;

@Service("bk.BkControllerService")
public class BkControllerService {

	@Autowired
	@Qualifier("bk.CheckLoginService")
	private CheckLoginService checkLoginService;
	
	@Autowired
	@Qualifier("bk.vo.checkLogin.CheckLoginRespTrans")
	private CheckLoginRespTrans checkLoginRespTrans;
	
	
	public Response checkLogin() {
		
		return ResponseUtil.response200(
				checkLoginRespTrans.dtoToVo(
						checkLoginService.checkLogin()));
	}
}

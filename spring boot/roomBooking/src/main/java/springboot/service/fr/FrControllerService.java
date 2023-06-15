package springboot.service.fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.vo.Response;
import springboot.trans.fr.vo.checkLogin.CheckLoginRespTrans;
import util.ResponseUtil;

@Service("service.fr.FrControllerService")
public class FrControllerService {

	@Autowired
	@Qualifier("fr.CheckLoginService")
	private CheckLoginService checkLoginService;
	
	
	@Autowired
	@Qualifier("fr.vo.checkLogin.CheckLoginRespTrans")
	private CheckLoginRespTrans checkLoginRespTrans;
	
	
	public Response checkLogin() {
		
		return ResponseUtil.response200(
				checkLoginRespTrans.dtoToVo(
						checkLoginService.checkLogin()));
	}
}

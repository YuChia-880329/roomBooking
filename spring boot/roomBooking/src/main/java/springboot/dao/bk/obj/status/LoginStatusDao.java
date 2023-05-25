package springboot.dao.bk.obj.status;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.bk.obj.status.LoginDto;
import springboot.bean.obj.bk.status.Login;
import springboot.memory.status.StatusDao;
import springboot.memory.status.bk.LoginStatus;
import springboot.trans.bk.memory.status.LoginTrans;

@Repository
@SessionScope
public class LoginStatusDao extends StatusDao<Login, LoginDto, LoginStatus, LoginTrans> {

	public LoginStatusDao(LoginStatus cache) {
		
		super(cache);
	}

	@Override
	protected void setTrans(LoginTrans trans) {
		
		this.trans = trans;
	}
}

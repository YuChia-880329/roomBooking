package springboot.dao.bk.login.memory.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.bk.login.obj.status.login.LoginDto;
import springboot.bean.obj.bk.login.status.login.Login;
import springboot.memory.status.StatusDao;
import springboot.memory.status.bk.login.LoginStatus;
import springboot.trans.bk.login.obj.status.login.LoginTrans;

@Repository("bk.login.memory.status.LoginStatusDao")
@SessionScope
public class LoginStatusDao extends StatusDao<Login, LoginDto, LoginStatus, LoginTrans> {

	
	public LoginStatusDao(LoginStatus cache) {
		
		super(cache);
	}

	@Autowired
	@Qualifier("bk.login.obj.status.login.LoginTrans")
	@Override
	protected void setTrans(LoginTrans trans) {
		
		this.trans = trans;
	}
}
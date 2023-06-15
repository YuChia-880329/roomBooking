package springboot.dao.fr.login.memory.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.SessionScope;

import springboot.bean.dto.fr.login.obj.status.login.LoginDto;
import springboot.bean.obj.fr.login.status.login.Login;
import springboot.memory.status.StatusDao;
import springboot.memory.status.fr.login.LoginStatus;
import springboot.trans.fr.login.obj.status.login.LoginTrans;

@Repository("fr.login.memory.status.LoginStatusDao")
@SessionScope
public class LoginStatusDao extends StatusDao<Login, LoginDto, LoginStatus, LoginTrans> {

	
	public LoginStatusDao(LoginStatus cache) {
		
		super(cache);
	}

	@Autowired
	@Qualifier("fr.login.obj.status.login.LoginTrans")
	@Override
	protected void setTrans(LoginTrans trans) {
		
		this.trans = trans;
	}
}
package springboot.service.fr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import springboot.bean.dto.fr.login.obj.status.login.LoginDto;
import springboot.bean.dto.fr.vo.memberName.MemberNameRespDto;
import springboot.bean.dto.model.MemberDto;
import springboot.dao.fr.login.memory.status.LoginStatusDao;
import springboot.dao.model.inner.MemberDaoInner;

@Service("fr.MemberNameService")
public class MemberNameService {

	@Autowired
	@Qualifier("fr.login.memory.status.LoginStatusDao")
	private LoginStatusDao loginStatusDao;
	@Autowired
	@Qualifier("model.inner.MemberDaoInner")
	private MemberDaoInner memberDaoInner;
	
	
	
	public MemberNameRespDto memberName() {
		
		LoginDto login = loginStatusDao.getStatus();
		
		boolean isLogin = login.isLogin();
		
		MemberDto member = null;
		if(isLogin)
			member = memberDaoInner.findById(login.getMemberId()).get();
		
		return MemberNameRespDto.builder()
				.isLogin(isLogin)
				.memberName(isLogin ? member.getName() : "")
				.build();
	}
}

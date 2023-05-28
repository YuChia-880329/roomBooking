package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.MemberDto;
import springboot.bean.model.Member;
import springboot.dao.model.MemberDao;
import springboot.trans.model.MemberTrans;

@Repository("model.inner.MemberDaoInner")
public class MemberDaoInner extends DaoInner<Member, Integer, MemberDto, MemberTrans, MemberDao> {

	
	public MemberDto findFirstByAccount(String account){
		
		return trans.modelToDto(dao.findFirstByAccount(account));
	}
	

	@Autowired
	@Qualifier("model.MemberDao")
	@Override
	public void setDao(MemberDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.MemberTrans")
	@Override
	public void setTrans(MemberTrans trans) {

		this.trans = trans;
	}
}

package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.MemberDto;
import springboot.bean.model.Member;
import springboot.dao.model.MemberDao;
import springboot.trans.model.MemberTrans;

@Repository
public class MemberDaoInner extends DaoInner<Member, Integer, MemberDto, MemberTrans, MemberDao> {

	
	public MemberDto findFirstByAccount(String account){
		
		return trans.modelToDto(dao.findFirstByAccount(account));
	}
	
	
	
	
	@Autowired
	@Override
	public void setDao(MemberDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(MemberTrans trans) {

		this.trans = trans;
	}
}

package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Member;

@Repository("model.MemberDao")
public interface MemberDao extends JpaRepository<Member, Integer> {
	
	public Member findFirstByAccount(String account);
}

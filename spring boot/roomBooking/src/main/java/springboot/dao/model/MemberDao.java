package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.Member;

public interface MemberDao extends JpaRepository<Member, Integer> {
}

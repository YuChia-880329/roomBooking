package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.MemberDto;
import springboot.bean.model.Member;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class MemberTrans implements ModelRiTrans<Member, MemberDto>, ModelWoTrans<Member, MemberDto> {

	@Override
	public Member dtoToModelImpl(MemberDto dto) {
		
		return null;
	}

	@Override
	public MemberDto modelToDtoImpl(Member model) {
		
		return null;
	}
}

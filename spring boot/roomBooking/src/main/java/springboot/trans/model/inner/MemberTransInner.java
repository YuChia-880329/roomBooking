package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.MemberDto;
import springboot.bean.model.Member;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class MemberTransInner implements ModelRiTrans<Member, MemberDto>, ModelWoTrans<Member, MemberDto> {

	@Override
	public Member dtoToModelImpl(MemberDto dto) {
		
		return Member.builder()
				.id(dto.getId())
				.account(dto.getAccount())
				.password(dto.getPassword())
				.name(dto.getName())
				.phone(dto.getPhone())
				.bookingOrders(null)
				.build();
	}

	@Override
	public MemberDto modelToDtoImpl(Member model) {
		
		return MemberDto.builder()
				.id(model.getId())
				.account(model.getAccount())
				.password(model.getPassword())
				.name(model.getName())
				.phone(model.getPhone())
				.bookingOrders(null)
				.build();
	}
}

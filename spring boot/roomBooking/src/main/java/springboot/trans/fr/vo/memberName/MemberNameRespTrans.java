package springboot.trans.fr.vo.memberName;

import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.vo.memberName.MemberNameRespDto;
import springboot.bean.vo.fr.memberName.MemberNameResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.vo.memberName.MemberNameRespTrans")
public class MemberNameRespTrans implements VoWoTrans<MemberNameResp, MemberNameRespDto> {

	@Override
	public MemberNameResp dtoToVoImpl(MemberNameRespDto dto) {
		
		return MemberNameResp.builder()
				.isLogin(dto.isLogin())
				.memberName(dto.getMemberName())
				.build();
	}
}

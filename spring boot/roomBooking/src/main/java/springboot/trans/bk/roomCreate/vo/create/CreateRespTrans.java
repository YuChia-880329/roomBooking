package springboot.trans.bk.roomCreate.vo.create;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomCreate.vo.create.CreateRespDto;
import springboot.bean.vo.bk.roomCreate.create.CreateResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomCreate.vo.create.CreateRespTrans")
public class CreateRespTrans implements VoWoTrans<CreateResp, CreateRespDto> {

	@Override
	public CreateResp dtoToVoImpl(CreateRespDto dto) {
		
		return CreateResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}

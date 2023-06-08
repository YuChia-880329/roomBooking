package springboot.trans.bk.roomUpdate.vo.update;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.update.UpdateRespDto;
import springboot.bean.vo.bk.roomUpdate.update.UpdateResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.update.UpdateRespTrans")
public class UpdateRespTrans implements VoWoTrans<UpdateResp, UpdateRespDto> {

	@Override
	public UpdateResp dtoToVoImpl(UpdateRespDto dto) {
		
		return UpdateResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}

package springboot.trans.bk.hotelInfo.vo.update;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.hotelInfo.vo.update.UpdateRespDto;
import springboot.bean.vo.bk.hotelInfo.update.UpdateResp;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.hotelInfo.vo.update.UpdateRespTrans")
public class UpdateRespTrans implements VoWoTrans<UpdateResp, UpdateRespDto> {

	@Override
	public UpdateResp dtoToVoImpl(UpdateRespDto dto) {
		
		return UpdateResp.builder()
				.success(dto.isSuccess())
				.msg(dto.getMsg())
				.build();
	}
}

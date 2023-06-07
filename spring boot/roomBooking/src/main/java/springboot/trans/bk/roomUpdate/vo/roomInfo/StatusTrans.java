package springboot.trans.bk.roomUpdate.vo.roomInfo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.StatusDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.Status;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.roomInfo.StatusTrans")
public class StatusTrans implements VoWoTrans<Status, StatusDto> {

	@Override
	public Status dtoToVoImpl(StatusDto dto) {
		
		return Status.builder()
				.able(dto.isAble())
				.statusId(dto.getStatusId())
				.build();
	}
}

package springboot.trans.bk.roomUpdate.vo.roomInfo;

import org.springframework.stereotype.Controller;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomImgDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomImg;
import tmpl.trans.bean.vo.VoWoTrans;

@Controller("bk.roomUpdate.vo.roomInfo.RoomImgTrans")
public class RoomImgTrans implements VoWoTrans<RoomImg, RoomImgDto> {

	@Override
	public RoomImg dtoToVoImpl(RoomImgDto dto) {
		
		return RoomImg.builder()
				.id(dto.getId())
				.imgName(dto.getImgName())
				.url(dto.getUrl())
				.order(dto.getOrder())
				.build();
	}
}

package springboot.trans.bk.roomUpdate.vo.roomInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomUpdate.vo.roomInfo.RoomImgsDto;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomImg;
import springboot.bean.vo.bk.roomUpdate.roomInfo.RoomImgs;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomUpdate.vo.roomInfo.RoomImgsTrans")
public class RoomImgsTrans implements VoWoTrans<RoomImgs, RoomImgsDto> {

	@Autowired
	@Qualifier("bk.roomUpdate.vo.roomInfo.RoomImgTrans")
	private RoomImgTrans roomImgTrans;
	
	@Override
	public RoomImgs dtoToVoImpl(RoomImgsDto dto) {
		
		return RoomImgs.builder()
				.hasImg(dto.isHasImg())
				.imgs(roomImgTrans.dtoListToVoArray(dto.getImgs(), size -> new RoomImg[size]))
				.currentImg(roomImgTrans.dtoToVo(dto.getCurrentImg()))
				.build();
	}
}

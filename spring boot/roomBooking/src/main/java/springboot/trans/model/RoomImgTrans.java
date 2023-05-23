package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.model.RoomImg;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class RoomImgTrans implements ModelRiTrans<RoomImg, RoomImgDto>, ModelWoTrans<RoomImg, RoomImgDto> {

	@Override
	public RoomImg dtoToModelImpl(RoomImgDto dto) {
		
		return null;
	}

	@Override
	public RoomImgDto modelToDtoImpl(RoomImg model) {
		
		return null;
	}
}

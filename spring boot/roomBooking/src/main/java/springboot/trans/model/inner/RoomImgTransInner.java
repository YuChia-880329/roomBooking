package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.model.RoomImg;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class RoomImgTransInner implements ModelRiTrans<RoomImg, RoomImgDto>, ModelWoTrans<RoomImg, RoomImgDto> {

	@Override
	public RoomImg dtoToModelImpl(RoomImgDto dto) {
		
		return RoomImg.builder()
				.id(dto.getId())
				.imageName(dto.getImageName())
				.imageOrder(dto.getImageOrder())
				.roomId(dto.getRoomId())
				.room(null)
				.build();
	}

	@Override
	public RoomImgDto modelToDtoImpl(RoomImg model) {
		
		return RoomImgDto.builder()
				.id(model.getId())
				.imageName(model.getImageName())
				.imageOrder(model.getImageOrder())
				.roomId(model.getRoomId())
				.room(null)
				.build();
	}
}

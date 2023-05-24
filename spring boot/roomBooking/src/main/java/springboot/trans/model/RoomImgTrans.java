package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.model.RoomImg;
import springboot.trans.model.inner.RoomImgTransInner;

@Component
public class RoomImgTrans extends ModelTrans<RoomImg, RoomImgDto> {

	@Autowired
	private RoomImgTransInner roomImgTransInner;
	
	@Autowired
	private RoomTrans roomTrans;
	
	
	@Override
	RoomImg toModelRecrs(RoomImgDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, roomImgTransInner::dtoToModel, cache::getRoomImgCache, cache::setRoomImgCache, model -> {
			
			model.setRoom(roomTrans.toModelRecrs(dto.getRoom(), cache));
		});
	}
	@Override
	RoomImgDto toDtoRecrs(RoomImg model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, roomImgTransInner::modelToDto, cache::getRoomImgCache, cache::setRoomImgCache, dto -> {
			
			dto.setRoom(roomTrans.toDtoRecrs(model.getRoom(), cache));
		});
	}
}

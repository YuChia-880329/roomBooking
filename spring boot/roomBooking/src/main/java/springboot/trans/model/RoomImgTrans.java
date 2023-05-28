package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.model.RoomImg;
import springboot.trans.model.inner.RoomImgTransInner;

@Component("model.RoomImgTrans")
public class RoomImgTrans extends ModelTrans<RoomImg, RoomImgDto> {

	@Autowired
	@Qualifier("model.inner.RoomImgTransInner")
	private RoomImgTransInner roomImgTransInner;
	
	@Autowired
	@Qualifier("model.RoomTrans")
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

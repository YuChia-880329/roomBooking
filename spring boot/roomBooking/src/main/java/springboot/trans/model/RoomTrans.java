package springboot.trans.model;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class RoomTrans implements ModelRiTrans<Room, RoomDto>, ModelWoTrans<Room, RoomDto> {

	@Override
	public Room dtoToModelImpl(RoomDto dto) {
		
		return null;
	}

	@Override
	public RoomDto modelToDtoImpl(Room model) {
		
		return null;
	}

}

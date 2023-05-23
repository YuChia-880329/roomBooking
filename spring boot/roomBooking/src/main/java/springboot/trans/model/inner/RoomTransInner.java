package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component
public class RoomTransInner implements ModelRiTrans<Room, RoomDto>, ModelWoTrans<Room, RoomDto> {

	@Override
	public Room dtoToModelImpl(RoomDto dto) {
		
		return Room.builder()
				.id(dto.getId())
				.name(dto.getName())
				.totalNum(dto.getTotalNum())
				.invalidNum(dto.getInvalidNum())
				.usedNum(dto.getUsedNum())
				.price(dto.getPrice())
				.singleBedNum(dto.getSingleBedNum())
				.doubleBedNum(dto.getDoubleBedNum())
				.area(dto.getArea())
				.sceneId(dto.getSceneId())
				.hotelId(dto.getHotelId())
				.scene(null)
				.hotel(null)
				.showers(null)
				.roomImgs(null)
				.bookingOrders(null)
				.build();
	}

	@Override
	public RoomDto modelToDtoImpl(Room model) {
		
		return RoomDto.builder()
				.id(model.getId())
				.name(model.getName())
				.totalNum(model.getTotalNum())
				.invalidNum(model.getInvalidNum())
				.usedNum(model.getUsedNum())
				.price(model.getPrice())
				.singleBedNum(model.getSingleBedNum())
				.doubleBedNum(model.getDoubleBedNum())
				.area(model.getArea())
				.sceneId(model.getSceneId())
				.hotelId(model.getHotelId())
				.scene(null)
				.hotel(null)
				.showers(null)
				.roomImgs(null)
				.bookingOrders(null)
				.build();
	}

}

package springboot.trans.model.inner;

import org.springframework.stereotype.Component;

import enumeration.RoomStatus;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import tmpl.trans.bean.model.ModelRiTrans;
import tmpl.trans.bean.model.ModelWoTrans;

@Component("model.inner.RoomTransInner")
public class RoomTransInner implements ModelRiTrans<Room, RoomDto>, ModelWoTrans<Room, RoomDto> {

	@Override
	public Room dtoToModelImpl(RoomDto dto) {
		
		return Room.builder()
				.id(dto.getId())
				.name(dto.getName())
				.totalNum(dto.getTotalNum())
				.invalidNum(dto.getInvalidNum())
				.price(dto.getPrice())
				.singleBedNum(dto.getSingleBedNum())
				.doubleBedNum(dto.getDoubleBedNum())
				.peopleNum(dto.getPeopleNum())
				.area(dto.getArea())
				.sceneId(dto.getSceneId())
				.hotelId(dto.getHotelId())
				.status(String.valueOf(dto.getStatus().getCode()))
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
				.price(model.getPrice())
				.singleBedNum(model.getSingleBedNum())
				.doubleBedNum(model.getDoubleBedNum())
				.peopleNum(model.getPeopleNum())
				.area(model.getArea())
				.sceneId(model.getSceneId())
				.hotelId(model.getHotelId())
				.status(RoomStatus.getByCode(Integer.parseInt(model.getStatus())))
				.scene(null)
				.hotel(null)
				.showers(null)
				.roomImgs(null)
				.bookingOrders(null)
				.build();
	}

}

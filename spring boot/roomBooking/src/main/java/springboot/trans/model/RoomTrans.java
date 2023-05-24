package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import springboot.trans.model.inner.RoomTransInner;

@Component
public class RoomTrans extends ModelTrans<Room, RoomDto> {

	@Autowired
	private RoomTransInner roomTransInner;
	
	@Autowired
	private SceneTrans sceneTrans;
	@Autowired
	private HotelTrans hotelTrans;
	@Autowired
	private ShowerTrans showerTrans;
	@Autowired
	private RoomImgTrans roomImgTrans;
	@Autowired
	private BookingOrderTrans bookingOrderTrans;

	
	@Override
	Room toModelRecrs(RoomDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, roomTransInner::dtoToModel, cache::getRoomCache, cache::setRoomCache, model -> {
			
			model.setScene(sceneTrans.toModelRecrs(dto.getScene(), cache));
			model.setHotel(hotelTrans.toModelRecrs(dto.getHotel(), cache));
			model.setShowers(showerTrans.toModelRecrs(dto.getShowers(), cache));
			model.setRoomImgs(roomImgTrans.toModelRecrs(dto.getRoomImgs(), cache));
			model.setBookingOrders(bookingOrderTrans.toModelRecrs(dto.getBookingOrders(), cache));
		});
	}
	@Override
	RoomDto toDtoRecrs(Room model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, roomTransInner::modelToDto, cache::getRoomCache, cache::setRoomCache, dto -> {
			
			dto.setScene(sceneTrans.toDtoRecrs(model.getScene(), cache));
			dto.setHotel(hotelTrans.toDtoRecrs(model.getHotel(), cache));
			dto.setShowers(showerTrans.toDtoRecrs(model.getShowers(), cache));
			dto.setRoomImgs(roomImgTrans.toDtoRecrs(model.getRoomImgs(), cache));
			dto.setBookingOrders(bookingOrderTrans.toDtoRecrs(model.getBookingOrders(), cache));
		});
	}
}

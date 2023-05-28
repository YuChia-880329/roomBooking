package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import springboot.trans.model.inner.RoomTransInner;

@Component("model.RoomTrans")
public class RoomTrans extends ModelTrans<Room, RoomDto> {

	@Autowired
	@Qualifier("model.inner.RoomTransInner")
	private RoomTransInner roomTransInner;
	
	@Autowired
	@Qualifier("model.SceneTrans")
	private SceneTrans sceneTrans;
	@Autowired
	@Qualifier("model.HotelTrans")
	private HotelTrans hotelTrans;
	@Autowired
	@Qualifier("model.ShowerTrans")
	private ShowerTrans showerTrans;
	@Autowired
	@Qualifier("model.RoomImgTrans")
	private RoomImgTrans roomImgTrans;
	@Autowired
	@Qualifier("model.BookingOrderTrans")
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

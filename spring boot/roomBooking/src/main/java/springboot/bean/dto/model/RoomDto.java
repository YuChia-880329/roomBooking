package springboot.bean.dto.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = {"hotel", "bookingOrders"})
public class RoomDto {

	private int id;
	private String name;
	private int totalNum;
	private int invalidNum;
	private int usedNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int area;
	private int sceneId;
	private int hotelId;
	private SceneDto scene;
	private HotelDto hotel;
	private List<ShowerDto> showers;
	private List<RoomImgDto> roomImgs;
	private List<BookingOrderDto> bookingOrders;
}

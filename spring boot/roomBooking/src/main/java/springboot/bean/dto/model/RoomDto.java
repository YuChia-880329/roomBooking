package springboot.bean.dto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import enumeration.RoomStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = {"hotel", "bookingOrders"})
public class RoomDto {

	private int id;
	private String name;
	private int totalNum;
	private int invalidNum;
	private int price;
	private int singleBedNum;
	private int doubleBedNum;
	private int peopleNum;
	private int area;
	private int sceneId;
	private int hotelId;
	private RoomStatus status;
	private SceneDto scene;
	@JsonIgnore
	private HotelDto hotel;
	private List<ShowerDto> showers;
	private List<RoomImgDto> roomImgs;
	@JsonIgnore
	private List<BookingOrderDto> bookingOrders;
}

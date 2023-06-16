package springboot.bean.dto.fr.shoppingCart.vo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {

	private int itemId;
	private List<ImageDto> images;
	private String hotelName;
	private String roomName;
	private int num;
	private LocalDate checkinDate;
	private LocalDate checkoutDate;
	private LocalTime checkinTime;
	private int price;
}

package springboot.bean.vo.fr.hotelPage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Room {

	private int roomId;
	private String name;
	private int validNum;
	private int price;
	private Features features;
	private Image[] images;
}

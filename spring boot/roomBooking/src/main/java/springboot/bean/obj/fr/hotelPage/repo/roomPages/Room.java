package springboot.bean.obj.fr.hotelPage.repo.roomPages;

import java.util.List;

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
	private List<Image> images;
}

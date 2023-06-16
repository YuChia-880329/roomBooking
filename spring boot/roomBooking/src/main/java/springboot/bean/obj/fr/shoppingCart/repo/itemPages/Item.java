package springboot.bean.obj.fr.shoppingCart.repo.itemPages;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Item {

	private int itemId;
	private List<Image> images;
	private String hotelName;
	private String roomName;
	private int hotelId;
}

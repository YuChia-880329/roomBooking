package springboot.bean.obj.fr.db.shoppingCart;

import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Item {

	private int num;
	private LocalTime checkinTime;
}

package springboot.bean.obj.fr.db.shoppingCart;

import java.time.LocalDate;
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

	private LocalDate checkinDate;
	private LocalDate checkoutDate;
	private LocalTime checkinTime;
	private int num;
}

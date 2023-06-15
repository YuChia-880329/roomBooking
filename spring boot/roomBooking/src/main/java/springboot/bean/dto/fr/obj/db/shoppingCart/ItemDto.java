package springboot.bean.dto.fr.obj.db.shoppingCart;

import java.time.LocalTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ItemDto {

	private int roomId;
	private int num;
	private LocalTime checkinTime;
}

package springboot.bean.vo.fr.searchHotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchHotelResp extends Data {

	private int hotelId;
	private boolean hasHotel;
	private String msg;
}

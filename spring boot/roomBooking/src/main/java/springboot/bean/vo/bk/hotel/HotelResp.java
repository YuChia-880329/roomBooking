package springboot.bean.vo.bk.hotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelResp extends Data {

	private int hotelId;
	private String hotelName;
}

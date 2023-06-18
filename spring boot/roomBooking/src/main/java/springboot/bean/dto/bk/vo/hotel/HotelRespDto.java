package springboot.bean.dto.bk.vo.hotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelRespDto {

	private int hotelId;
	private String hotelName;
}

package springboot.bean.dto.bk.vo.hotelName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelNameRespDto {

	private String hotelName;
}
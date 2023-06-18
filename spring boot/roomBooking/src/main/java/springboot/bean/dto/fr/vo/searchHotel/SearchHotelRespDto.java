package springboot.bean.dto.fr.vo.searchHotel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchHotelRespDto {

	private int hotelId;
	private boolean hasHotel;
	private String msg;
}

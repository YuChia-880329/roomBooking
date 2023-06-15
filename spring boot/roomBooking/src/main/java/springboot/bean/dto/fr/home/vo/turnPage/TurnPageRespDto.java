package springboot.bean.dto.fr.home.vo.turnPage;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.dto.fr.home.vo.HotelRoomDto;
import springboot.bean.dto.vo.PaginationDto;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class TurnPageRespDto {

	private List<HotelRoomDto> hotels;
	private PaginationDto pagination;
}

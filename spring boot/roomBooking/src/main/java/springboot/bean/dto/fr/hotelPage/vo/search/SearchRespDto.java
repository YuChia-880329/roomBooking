package springboot.bean.dto.fr.hotelPage.vo.search;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.dto.vo.PaginationDto;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchRespDto {

	private List<RoomDto> rooms;
	private PaginationDto pagination;
}

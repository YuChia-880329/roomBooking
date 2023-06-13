package springboot.bean.vo.fr.home.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;
import springboot.bean.vo.Pagination;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class SearchResp extends Data {

	private HotelRoom[] hotels;
	private Pagination pagination;
}

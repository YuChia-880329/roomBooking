package springboot.bean.dto.fr.home.obj.repo.hotelRoomPages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class InputDto {

	private SearchParamDto searchParam;
}

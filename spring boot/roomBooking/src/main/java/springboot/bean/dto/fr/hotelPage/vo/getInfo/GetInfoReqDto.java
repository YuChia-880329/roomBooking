package springboot.bean.dto.fr.hotelPage.vo.getInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class GetInfoReqDto {

	int hotelId;
}

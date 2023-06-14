package springboot.bean.vo.fr.hotelPage.getInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class GetInfoReq {

	String hotelId;
}

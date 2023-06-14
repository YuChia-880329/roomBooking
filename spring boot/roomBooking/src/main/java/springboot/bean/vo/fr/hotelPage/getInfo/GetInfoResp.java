package springboot.bean.vo.fr.hotelPage.getInfo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class GetInfoResp extends Data {
	
	private String imgUrl;
	private String hotelName;
	private String address;
	private String description;
    private Feature[] features;
}

package springboot.bean.dto.fr.hotelPage.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomDto {

	private int roomId;
	private String name;
	private int validNum;
	private int price;
	private FeaturesDto features;
	private List<ImageDto> images;
}

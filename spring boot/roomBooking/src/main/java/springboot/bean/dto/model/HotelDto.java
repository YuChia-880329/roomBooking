package springboot.bean.dto.model;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class HotelDto {

	private int id;
	private String name;
	private String sectionCode;
	private String address;
	private String introduction;
	private String imgName;
	private int accountId;
	private SectionDto section;
	private HotelAccountDto account;
	private List<HotelFeatureDto> features;
	private List<RoomDto> rooms;
}

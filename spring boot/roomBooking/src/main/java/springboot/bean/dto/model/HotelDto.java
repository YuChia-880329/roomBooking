package springboot.bean.dto.model;

import java.util.List;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
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

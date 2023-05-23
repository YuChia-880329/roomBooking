package springboot.bean.dto.model;

import java.util.List;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = "rooms")
public class ShowerDto {
	
	private int id;
	private String name;
	private List<RoomDto> rooms;
}

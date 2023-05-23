package springboot.bean.dto.model;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
@ToString(exclude = "room")
public class RoomImgDto {

	private int id;
	private String imageName;
	private int imageOrder;
	private int roomId;
	private RoomDto room;
}

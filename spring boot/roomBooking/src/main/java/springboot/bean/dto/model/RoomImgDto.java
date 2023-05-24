package springboot.bean.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "room")
public class RoomImgDto {

	private int id;
	private String imageName;
	private int imageOrder;
	private int roomId;
	@JsonIgnore
	private RoomDto room;
}

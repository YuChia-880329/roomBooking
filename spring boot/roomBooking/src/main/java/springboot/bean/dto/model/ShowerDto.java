package springboot.bean.dto.model;

import java.util.List;

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
@ToString(exclude = "rooms")
public class ShowerDto {
	
	private int id;
	private String name;
	@JsonIgnore
	private List<RoomDto> rooms;
}

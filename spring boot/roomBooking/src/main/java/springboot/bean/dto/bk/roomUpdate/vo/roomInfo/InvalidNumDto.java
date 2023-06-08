package springboot.bean.dto.bk.roomUpdate.vo.roomInfo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class InvalidNumDto {

	private List<Integer> options;
	private int value;
}

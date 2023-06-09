package springboot.bean.dto.bk.roomCreate.vo.create;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CreateRespDto {

	private boolean success;
	private String msg;
}

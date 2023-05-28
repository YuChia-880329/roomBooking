package springboot.bean.dto.bk.login.vo.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ResultDto {

	private boolean success;
	private String msg;
}

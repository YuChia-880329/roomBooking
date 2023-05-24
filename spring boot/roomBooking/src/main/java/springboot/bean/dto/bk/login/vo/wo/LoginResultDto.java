package springboot.bean.dto.bk.login.vo.wo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LoginResultDto {

	private boolean success;
	private String msg;
}

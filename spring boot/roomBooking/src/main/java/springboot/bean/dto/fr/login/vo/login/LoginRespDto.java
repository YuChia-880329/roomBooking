package springboot.bean.dto.fr.login.vo.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LoginRespDto {

	private boolean success;
	private String msg;
}

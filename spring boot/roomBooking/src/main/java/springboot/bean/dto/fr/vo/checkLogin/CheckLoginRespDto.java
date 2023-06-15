package springboot.bean.dto.fr.vo.checkLogin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckLoginRespDto {

	private boolean login;
	private String msg;
}

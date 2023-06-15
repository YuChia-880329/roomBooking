package springboot.bean.dto.fr.login.obj.status.login;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LoginDto {

	private boolean isLogin;
	private Integer HotelId;
}

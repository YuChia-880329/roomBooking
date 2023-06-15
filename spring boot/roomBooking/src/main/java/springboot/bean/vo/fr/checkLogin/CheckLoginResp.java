package springboot.bean.vo.fr.checkLogin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckLoginResp extends Data {

	private boolean login;
	private String msg;
}

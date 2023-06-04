package springboot.bean.vo.bk.checkLogin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Result {

	private boolean login;
	private String msg;
}

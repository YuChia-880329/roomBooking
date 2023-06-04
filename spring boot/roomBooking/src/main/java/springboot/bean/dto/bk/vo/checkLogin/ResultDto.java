package springboot.bean.dto.bk.vo.checkLogin;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ResultDto {

	private boolean login;
	private String msg;
}

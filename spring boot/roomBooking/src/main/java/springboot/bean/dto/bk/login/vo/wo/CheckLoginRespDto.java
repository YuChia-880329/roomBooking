package springboot.bean.dto.bk.login.vo.wo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class CheckLoginRespDto {

	private CheckLoginResultDto checkLoginResult;
}

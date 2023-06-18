package springboot.bean.dto.fr.vo.logout;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class LogoutRespDto {

	private boolean success;
	private String msg;
}

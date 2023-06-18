package springboot.bean.dto.fr.vo.memberName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class MemberNameRespDto {

	private boolean isLogin;
	private String memberName;
}

package springboot.bean.vo.fr.memberName;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class MemberNameResp extends Data {

	private boolean isLogin;
	private String memberName;
}

package springboot.bean.vo.wo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class Response {

	private ServerInfo serverInfo;
	private Data data;
}

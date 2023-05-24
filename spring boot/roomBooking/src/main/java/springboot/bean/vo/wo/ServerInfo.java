package springboot.bean.vo.wo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class ServerInfo {

	private String serverIp;
	private int statusCode;
	private String msg;
}

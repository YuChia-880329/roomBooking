package springboot.bean.vo.bk.roomCreate.allShowers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllShowersResp extends Data {

	private Shower[] showers;
}

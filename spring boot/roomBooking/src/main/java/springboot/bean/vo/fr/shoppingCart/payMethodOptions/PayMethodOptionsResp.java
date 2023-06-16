package springboot.bean.vo.fr.shoppingCart.payMethodOptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import springboot.bean.vo.Data;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethodOptionsResp extends Data {

	private Option[] options;
}

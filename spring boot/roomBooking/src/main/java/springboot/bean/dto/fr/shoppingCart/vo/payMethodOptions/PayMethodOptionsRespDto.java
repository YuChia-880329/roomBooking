package springboot.bean.dto.fr.shoppingCart.vo.payMethodOptions;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class PayMethodOptionsRespDto {

	private List<OptionDto> options;
}

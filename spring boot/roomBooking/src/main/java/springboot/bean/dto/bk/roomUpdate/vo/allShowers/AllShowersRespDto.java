package springboot.bean.dto.bk.roomUpdate.vo.allShowers;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class AllShowersRespDto {

	private List<ShowerDto> showers;
}

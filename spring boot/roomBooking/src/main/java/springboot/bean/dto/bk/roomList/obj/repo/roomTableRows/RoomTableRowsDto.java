package springboot.bean.dto.bk.roomList.obj.repo.roomTableRows;

import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@Getter
@Setter
public class RoomTableRowsDto {

	private Map<Integer, List<RoomTableRowDto>> roomTableRowMap;
}

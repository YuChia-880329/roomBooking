package springboot.bean.obj.bk.roomList.repo.roomTableRows;

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
public class RoomTableRows {

	private Map<Integer, List<RoomTableRow>> roomTableRowMap;
}

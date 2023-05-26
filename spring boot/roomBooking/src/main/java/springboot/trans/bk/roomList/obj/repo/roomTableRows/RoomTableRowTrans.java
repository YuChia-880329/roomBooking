package springboot.trans.bk.roomList.obj.repo.roomTableRows;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.RoomTableRowDto;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.RoomTableRow;
import springboot.memory.repo.RepoObjTrans;

@Component
public class RoomTableRowTrans extends RepoObjTrans<RoomTableRow, RoomTableRowDto> {

	@Override
	public RoomTableRowDto objToDtoImpl(RoomTableRow obj) {
		
		return RoomTableRowDto.builder()
				.name(obj.getName())
				.totalNum(obj.getTotalNum())
				.usedNum(obj.getUsedNum())
				.invalidNum(obj.getInvalidNum())
				.price(obj.getPrice())
				.build();
	}

	@Override
	public RoomTableRow dtoToObjImpl(RoomTableRowDto dto) {
		
		return RoomTableRow.builder()
				.name(dto.getName())
				.totalNum(dto.getTotalNum())
				.usedNum(dto.getUsedNum())
				.invalidNum(dto.getInvalidNum())
				.price(dto.getPrice())
				.build();
	}
}

package springboot.trans.bk.roomList.obj.repo.roomTableRows;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.roomTableRows.RoomTableRowsDto;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.RoomTableRows;
import springboot.memory.repo.RepoObjTrans;

@Component
public class RoomTableRowsTrans extends RepoObjTrans<RoomTableRows, RoomTableRowsDto> {

	@Autowired
	private RoomTableRowTrans roomTableRowTrans;
	
	
	@Override
	public RoomTableRowsDto objToDtoImpl(RoomTableRows obj) {
		
		return RoomTableRowsDto.builder()
				.roomTableRowMap(obj.getRoomTableRowMap().entrySet().stream()
						.collect(Collectors.toMap(
								entry -> entry.getKey(), 
								entry -> roomTableRowTrans.objListToDtoList(entry.getValue()))))
				.build();
	}


	@Override
	public RoomTableRows dtoToObjImpl(RoomTableRowsDto dto) {
		
		return RoomTableRows.builder()
				.roomTableRowMap(dto.getRoomTableRowMap().entrySet().stream()
						.collect(Collectors.toMap(
								entry -> entry.getKey(), 
								entry -> roomTableRowTrans.dtoListToObjList(entry.getValue()))))
				.build();
	}
}

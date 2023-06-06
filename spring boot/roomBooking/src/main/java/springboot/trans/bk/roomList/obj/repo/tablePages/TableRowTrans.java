package springboot.trans.bk.roomList.obj.repo.tablePages;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.TableRowDto;
import springboot.bean.obj.bk.roomList.repo.tablePages.TableRow;
import springboot.memory.repo.RepoOutputTrans;

@Component("bk.roomList.obj.repo.tablePages.TableRowTrans")
public class TableRowTrans extends RepoOutputTrans<TableRow, TableRowDto> {

	@Override
	protected TableRow dtoToOutputImpl(TableRowDto dto) {
		
		return TableRow.builder()
				.name(dto.getName())
				.totalNum(dto.getTotalNum())
				.usedNum(dto.getUsedNum())
				.invalidNum(dto.getInvalidNum())
				.price(dto.getPrice())
				.status(dto.getStatus())
				.build();
	}

	@Override
	protected TableRowDto outputToDtoImpl(TableRow output) {
		
		return TableRowDto.builder()
				.name(output.getName())
				.totalNum(output.getTotalNum())
				.usedNum(output.getUsedNum())
				.invalidNum(output.getInvalidNum())
				.price(output.getPrice())
				.status(output.getStatus())
				.build();
	}
}

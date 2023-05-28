package springboot.trans.bk.roomList.vo.searchTable;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.searchTable.TableRowDto;
import springboot.bean.vo.bk.roomList.searchTable.TableRow;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomList.vo.searchTable.TableRowTrans")
public class TableRowTrans implements VoWoTrans<TableRow, TableRowDto> {

	@Override
	public TableRow dtoToVoImpl(TableRowDto dto) {
		
		return TableRow.builder()
				.name(dto.getName())
				.totalNum(dto.getTotalNum())
				.usedNum(dto.getUsedNum())
				.invalidNum(dto.getInvalidNum())
				.price(dto.getPrice())
				.build();
	}
}

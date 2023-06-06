package springboot.trans.bk.roomList.vo;

import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.TableRowDto;
import springboot.bean.vo.bk.roomList.TableRow;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomList.vo.TableRowTrans")
public class TableRowTrans implements VoWoTrans<TableRow, TableRowDto> {

	@Override
	public TableRow dtoToVoImpl(TableRowDto dto) {
		
		return TableRow.builder()
				.index(dto.getIndex())
				.name(dto.getName())
				.totalNum(dto.getTotalNum())
				.usedNum(dto.getUsedNum())
				.invalidNum(dto.getInvalidNum())
				.price(dto.getPrice())
				.status(dto.getStatus().getDescription())
				.build();
	}
}

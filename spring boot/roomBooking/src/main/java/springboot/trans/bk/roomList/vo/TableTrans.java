package springboot.trans.bk.roomList.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.TableDto;
import springboot.bean.vo.bk.roomList.Table;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomList.vo.TableTrans")
public class TableTrans implements VoWoTrans<Table, TableDto> {

	@Autowired
	@Qualifier("bk.roomList.vo.TableRowTrans")
	private TableRowTrans tableRowTrans;
	
	@Override
	public Table dtoToVoImpl(TableDto dto) {
		
		return Table.builder()
				.tableRows(tableRowTrans.dtoListToVoList(dto.getTableRows()))
				.build();
	}
}

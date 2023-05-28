package springboot.trans.bk.roomList.vo.searchTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.vo.searchTable.TableDto;
import springboot.bean.vo.bk.roomList.searchTable.Table;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("bk.roomList.vo.searchTable.TableTrans")
public class TableTrans implements VoWoTrans<Table, TableDto> {

	@Autowired
	@Qualifier("bk.roomList.vo.searchTable.TableRowTrans")
	private TableRowTrans tableRowTrans;
	
	@Override
	public Table dtoToVoImpl(TableDto dto) {
		
		return Table.builder()
				.tableRows(tableRowTrans.dtoListToVoList(dto.getTableRows()))
				.build();
	}
}

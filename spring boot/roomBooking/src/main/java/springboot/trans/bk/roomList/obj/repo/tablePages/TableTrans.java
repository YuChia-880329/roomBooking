package springboot.trans.bk.roomList.obj.repo.tablePages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.TableDto;
import springboot.bean.obj.bk.roomList.repo.tablePages.Table;
import springboot.memory.repo.RepoOutputTrans;

@Component("bk.roomList.obj.repo.tablePages.TableTrans")
public class TableTrans extends RepoOutputTrans<Table, TableDto> {

	@Autowired
	@Qualifier("bk.roomList.obj.repo.tablePages.TableRowTrans")
	private TableRowTrans tableRowTrans;
	
	
	@Override
	protected Table dtoToOutputImpl(TableDto dto) {
		
		return Table.builder()
				.tableRows(tableRowTrans.dtoListToOutputList(dto.getTableRows()))
				.build();
	}


	@Override
	protected TableDto outputToDtoImpl(Table output) {
		
		return TableDto.builder()
				.tableRows(tableRowTrans.outputListToDtoList(output.getTableRows()))
				.build();
	}
}

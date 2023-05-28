package springboot.trans.bk.roomList.obj.repo.tablePages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.roomList.obj.repo.tablePages.TablePageDto;
import springboot.bean.obj.bk.roomList.repo.tablePages.TablePage;
import springboot.memory.repo.RepoOutputTrans;

@Component("bk.roomList.obj.repo.tablePages.TablePageTrans")
public class TablePageTrans extends RepoOutputTrans<TablePage, TablePageDto> {

	@Autowired
	@Qualifier("bk.roomList.obj.repo.tablePages.TableTrans")
	private TableTrans tableTrans;

	@Override
	protected TablePage dtoToOutputImpl(TablePageDto dto) {
		
		return TablePage.builder()
				.table(tableTrans.dtoToOutput(dto.getTable()))
				.currentPage(dto.getCurrentPage())
				.build();
	}

	@Override
	protected TablePageDto outputToDtoImpl(TablePage output) {
		
		return TablePageDto.builder()
				.table(tableTrans.outputToDto(output.getTable()))
				.currentPage(output.getCurrentPage())
				.build();
	}

}

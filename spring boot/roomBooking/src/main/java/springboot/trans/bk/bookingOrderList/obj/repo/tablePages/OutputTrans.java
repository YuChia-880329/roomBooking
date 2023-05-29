package springboot.trans.bk.bookingOrderList.obj.repo.tablePages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.bk.bookingOrderList.obj.repo.tablePages.OutputDto;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.Output;
import springboot.memory.repo.RepoOutputTrans;

@Component("bk.bookingOrderList.obj.repo.tablePages.OutputTrans")
public class OutputTrans extends RepoOutputTrans<Output, OutputDto> {

	@Autowired
	@Qualifier("bk.bookingOrderList.obj.repo.tablePages.TablePageTrans")
	private TablePageTrans tablePageTrans;
	

	@Override
	protected Output dtoToOutputImpl(OutputDto dto) {
		
		return Output.builder()
				.maxPage(dto.getMaxPage())
				.tablePage(tablePageTrans.dtoToOutput(dto.getTablePage()))
				.build();
	}

	@Override
	protected OutputDto outputToDtoImpl(Output output) {
		
		return OutputDto.builder()
				.maxPage(output.getMaxPage())
				.tablePage(tablePageTrans.outputToDto(output.getTablePage()))
				.build();
	}
}

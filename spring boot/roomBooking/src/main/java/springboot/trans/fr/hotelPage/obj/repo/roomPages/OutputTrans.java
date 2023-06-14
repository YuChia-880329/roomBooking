package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.OutputDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Output;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.OutputTrans")
public class OutputTrans extends RepoOutputTrans<Output, OutputDto> {

	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.RoomPageTrans")
	private RoomPageTrans roomPageTrans;
	
	
	@Override
	protected Output dtoToOutputImpl(OutputDto dto) {
		
		return Output.builder()
				.maxPage(dto.getMaxPage())
				.roomPage(roomPageTrans.dtoToObj(dto.getRoomPage()))
				.build();
	}

	@Override
	protected OutputDto outputToDtoImpl(Output output) {
		
		return OutputDto.builder()
				.maxPage(output.getMaxPage())
				.roomPage(roomPageTrans.objToDto(output.getRoomPage()))
				.build();
	}
}

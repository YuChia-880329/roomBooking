package springboot.trans.fr.home.obj.repo.hotelRoomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.home.obj.repo.hotelRoomPages.OutputDto;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.Output;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.home.obj.repo.homeRooms.OutputTrans")
public class OutputTrans extends RepoOutputTrans<Output, OutputDto> {

	@Autowired
	@Qualifier("fr.home.obj.repo.homeRooms.HotelRoomPageTrans")
	private HotelRoomPageTrans hotelRoomPageTrans;
	
	
	@Override
	protected Output dtoToOutputImpl(OutputDto dto) {
		
		return Output.builder()
				.maxPage(dto.getMaxPage())
				.hotelRoomPage(hotelRoomPageTrans.dtoToObj(dto.getHotelRoomPage()))
				.build();
	}

	@Override
	protected OutputDto outputToDtoImpl(Output output) {
		
		return OutputDto.builder()
				.maxPage(output.getMaxPage())
				.hotelRoomPage(hotelRoomPageTrans.objToDto(output.getHotelRoomPage()))
				.build();
	}
}

package springboot.trans.fr.hotelPage.obj.repo.roomPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.obj.repo.roomPages.RoomDto;
import springboot.bean.obj.fr.hotelPage.repo.roomPages.Room;
import springboot.memory.repo.RepoOutputTrans;

@Component("fr.hotelPage.obj.repo.roomPages.RoomTrans")
public class RoomTrans extends RepoOutputTrans<Room, RoomDto> {

	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.FeaturesTrans")
	private FeaturesTrans featuresTrans;
	@Autowired
	@Qualifier("fr.hotelPage.obj.repo.roomPages.ImageTrans")
	private ImageTrans imageTrans;
	
	@Override
	protected Room dtoToOutputImpl(RoomDto dto) {
		
		return Room.builder()
				.roomId(dto.getRoomId())
				.name(dto.getName())
				.validNum(dto.getValidNum())
				.price(dto.getPrice())
				.features(featuresTrans.dtoToObj(dto.getFeatures()))
				.images(imageTrans.dtoListToObjList(dto.getImages()))
				.build();
	}

	@Override
	protected RoomDto outputToDtoImpl(Room output) {
		
		return RoomDto.builder()
				.roomId(output.getRoomId())
				.name(output.getName())
				.validNum(output.getValidNum())
				.price(output.getPrice())
				.features(featuresTrans.objToDto(output.getFeatures()))
				.images(imageTrans.objListToDtoList(output.getImages()))
				.build();
	}
}

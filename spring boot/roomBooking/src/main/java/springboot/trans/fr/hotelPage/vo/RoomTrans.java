package springboot.trans.fr.hotelPage.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.fr.hotelPage.vo.RoomDto;
import springboot.bean.vo.fr.hotelPage.Image;
import springboot.bean.vo.fr.hotelPage.Room;
import tmpl.trans.bean.vo.VoWoTrans;

@Component("fr.hotelPage.vo.search.RoomTrans")
public class RoomTrans implements VoWoTrans<Room, RoomDto> {

	@Autowired
	@Qualifier("fr.hotelPage.vo.search.FeaturesTrans")
	private FeaturesTrans featuresTrans;
	@Autowired
	@Qualifier("fr.hotelPage.vo.search.ImageTrans")
	private ImageTrans imageTrans;
	
	@Override
	public Room dtoToVoImpl(RoomDto dto) {
		
		return Room.builder()
				.roomId(dto.getRoomId())
				.name(dto.getName())
				.validNum(dto.getValidNum())
				.price(dto.getPrice())
				.features(featuresTrans.dtoToVo(dto.getFeatures()))
				.images(imageTrans.dtoListToVoArray(dto.getImages(), size -> new Image[size]))
				.build();
	}
}

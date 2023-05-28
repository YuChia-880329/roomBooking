package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelDto;
import springboot.bean.model.Hotel;
import springboot.trans.model.inner.HotelTransInner;

@Component("model.HotelTrans")
public class HotelTrans extends ModelTrans<Hotel, HotelDto> {

	@Autowired
	@Qualifier("model.inner.HotelTransInner")
	private HotelTransInner hotelTransInner;
	
	@Autowired
	@Qualifier("model.SectionTrans")
	private SectionTrans sectionTrans;
	@Autowired
	@Qualifier("model.HotelAccountTrans")
	private HotelAccountTrans hotelAccountTrans;
	@Autowired
	@Qualifier("model.HotelFeatureTrans")
	private HotelFeatureTrans hotelFeatureTrans;
	@Autowired
	@Qualifier("model.RoomTrans")
	private RoomTrans roomTrans;
	
	@Override
	Hotel toModelRecrs(HotelDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, hotelTransInner::dtoToModel, cache::getHotelCache, cache::setHotelCache, model -> {
			
			model.setSection(sectionTrans.toModelRecrs(dto.getSection(), cache));
			model.setAccount(hotelAccountTrans.toModelRecrs(dto.getAccount(), cache));
			model.setFeatures(hotelFeatureTrans.toModelRecrs(dto.getFeatures(), cache));
			model.setRooms(roomTrans.toModelRecrs(dto.getRooms(), cache));
		});
	}
	@Override
	HotelDto toDtoRecrs(Hotel model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, hotelTransInner::modelToDto, cache::getHotelCache, cache::setHotelCache, dto -> {
			
			dto.setSection(sectionTrans.toDtoRecrs(model.getSection(), cache));
			dto.setAccount(hotelAccountTrans.toDtoRecrs(model.getAccount(), cache));
			dto.setFeatures(hotelFeatureTrans.toDtoRecrs(model.getFeatures(), cache));
			dto.setRooms(roomTrans.toDtoRecrs(model.getRooms(), cache));
		});
	}
}

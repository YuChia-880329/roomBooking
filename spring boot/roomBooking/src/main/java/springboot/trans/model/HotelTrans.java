package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.HotelDto;
import springboot.bean.model.Hotel;
import springboot.trans.model.inner.HotelTransInner;

@Component
public class HotelTrans extends ModelTrans<Hotel, HotelDto> {

	@Autowired
	private HotelTransInner hotelTransInner;
	
	@Autowired
	private SectionTrans sectionTrans;
	@Autowired
	private HotelAccountTrans hotelAccountTrans;
	@Autowired
	private HotelFeatureTrans hotelFeatureTrans;
	@Autowired
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

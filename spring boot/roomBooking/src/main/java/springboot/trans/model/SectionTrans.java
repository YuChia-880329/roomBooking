package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.SectionDto;
import springboot.bean.model.Section;
import springboot.trans.model.inner.SectionTransInner;

@Component
public class SectionTrans extends ModelTrans<Section, SectionDto> {

	@Autowired
	private SectionTransInner sectionTransInner;
	
	@Autowired
	private HotelTrans hotelTrans;
	
	
	@Override
	Section toModelRecrs(SectionDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, sectionTransInner::dtoToModel, cache::getSectionCache, cache::setSectionCache, model -> {
			
			model.setHotels(hotelTrans.toModelRecrs(dto.getHotels(), cache));
		});
	}
	@Override
	SectionDto toDtoRecrs(Section model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, sectionTransInner::modelToDto, cache::getSectionCache, cache::setSectionCache, dto -> {
			
			dto.setHotels(hotelTrans.toDtoRecrs(model.getHotels(), cache));
		});
	}
}

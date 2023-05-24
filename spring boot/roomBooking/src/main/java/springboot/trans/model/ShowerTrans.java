package springboot.trans.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import springboot.bean.dto.model.ShowerDto;
import springboot.bean.model.Shower;
import springboot.trans.model.inner.ShowerTransInner;

@Component
public class ShowerTrans extends ModelTrans<Shower, ShowerDto> {

	@Autowired
	private ShowerTransInner showerTransInner;
	
	@Autowired
	private RoomTrans roomTrans;
	
	
	@Override
	public Shower dtoToModelImpl(ShowerDto dto) {
		
		Shower model = showerTransInner.dtoToModel(dto);
		
		ToModelRecrsCache toModelRecrsCache = new ToModelRecrsCache();
		
		model.setRooms(roomTrans.toModelRecrs(dto.getRooms(), toModelRecrsCache));
		
		return model;
	}

	@Override
	public ShowerDto modelToDtoImpl(Shower model) {
		
		ShowerDto dto = showerTransInner.modelToDto(model);
		
		ToDtoRecrsCache toDtoRecrsCache = new ToDtoRecrsCache();
		
		dto.setRooms(roomTrans.toDtoRecrs(model.getRooms(), toDtoRecrsCache));
		
		return dto;
	}
	
	Shower toModelRecrs(ShowerDto dto, ToModelRecrsCache cache) {
		
		return toModelRecrs(dto, showerTransInner::dtoToModel, cache::getShowerCache, cache::setShowerCache, model -> {
			
			model.setRooms(roomTrans.toModelRecrs(dto.getRooms(), cache));
		});
	}
	ShowerDto toDtoRecrs(Shower model, ToDtoRecrsCache cache) {
		
		return toDtoRecrs(model, showerTransInner::modelToDto, cache::getShowerCache, cache::setShowerCache, dto -> {
			
			dto.setRooms(roomTrans.toDtoRecrs(model.getRooms(), cache));
		});
	}
}

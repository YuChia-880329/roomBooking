package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.HotelDto;
import springboot.bean.model.Feature;
import springboot.bean.model.Hotel;
import springboot.bean.model.NewFeature;
import springboot.bean.model.Room;
import springboot.dao.model.HotelDao;
import springboot.trans.model.HotelTrans;

@Repository("model.inner.HotelDaoInner")
public class HotelDaoInner extends DaoInner<Hotel, Integer, HotelDto, HotelTrans, HotelDao> {

	
	public HotelDto save(HotelDto dto) {
		
		return super.saveImpl(dto, dto.getId());
	}
	
	@Override
	protected Hotel copyModel(Hotel model1, Hotel model2) {
		
		model1.setName(model2.getName());
		model1.setSectionCode(model2.getSectionCode());
		model1.setAddress(model2.getAddress());
		model1.setIntroduction(model2.getIntroduction());
		model1.setImgName(model2.getImgName());
		
		List<Feature> features = model1.getFeatures();
		features.clear();
		features.addAll(model2.getFeatures());
		List<NewFeature> newFeatures = model1.getNewFeatures();
		newFeatures.clear();
		newFeatures.addAll(model2.getNewFeatures());
		List<Room> rooms = model1.getRooms();
		rooms.clear();
		rooms.addAll(model2.getRooms());
		
		model1.setFeatures(features);
		model1.setNewFeatures(newFeatures);
		model1.setRooms(rooms);
		
		return model1;
	}
	@Autowired
	@Qualifier("model.HotelDao")
	@Override
	public void setDao(HotelDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.HotelTrans")
	@Override
	public void setTrans(HotelTrans trans) {

		this.trans = trans;
	}
}

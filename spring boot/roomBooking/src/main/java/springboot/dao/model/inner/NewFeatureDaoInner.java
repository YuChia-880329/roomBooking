package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.NewFeatureDto;
import springboot.bean.model.NewFeature;
import springboot.dao.model.NewFeatureDao;
import springboot.trans.model.NewFeatureTrans;

@Repository("model.inner.NewFeatureDaoInner")
public class NewFeatureDaoInner extends DaoInner<NewFeature, Integer, NewFeatureDto, NewFeatureTrans, NewFeatureDao> {

	
	public List<NewFeatureDto> findByHotelId(int hotelId){
		
		return trans.modelListToDtoList(dao.findByHotelId(hotelId));
	}
	public List<NewFeatureDto> findByNameAndHotelId(String name, int hotelId){
		
		return trans.modelListToDtoList(dao.findByNameAndHotelId(name, hotelId));
	}
	
	
	
	@Autowired
	@Qualifier("model.NewFeatureDao")
	@Override
	public void setDao(NewFeatureDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.NewFeatureTrans")
	@Override
	public void setTrans(NewFeatureTrans trans) {
		
		this.trans = trans;
	}

}

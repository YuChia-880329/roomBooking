package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.HotelFeatureDto;
import springboot.bean.model.HotelFeature;
import springboot.dao.model.HotelFeatureDao;
import springboot.trans.model.HotelFeatureTrans;

@Repository
public class HotelFeatureDaoInner extends DaoInner<HotelFeature, Integer, HotelFeatureDto, HotelFeatureTrans, HotelFeatureDao> {

	@Autowired
	@Override
	public void setDao(HotelFeatureDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(HotelFeatureTrans trans) {
		
		this.trans = trans;
	}
}

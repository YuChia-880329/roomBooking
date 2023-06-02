package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.FeatureDto;
import springboot.bean.model.Feature;
import springboot.dao.model.FeatureDao;
import springboot.trans.model.FeatureTrans;

@Repository("model.inner.FeatureDaoInner")
public class FeatureDaoInner extends DaoInner<Feature, Integer, FeatureDto, FeatureTrans, FeatureDao> {

	
	public FeatureDto queryByName(String name) {
		
		return trans.modelToDto(dao.queryByName(name));
	}
	
	@Autowired
	@Qualifier("model.FeatureDao")
	@Override
	public void setDao(FeatureDao dao) {
		
		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.FeatureTrans")
	@Override
	public void setTrans(FeatureTrans trans) {
		
		this.trans = trans;
	}
}

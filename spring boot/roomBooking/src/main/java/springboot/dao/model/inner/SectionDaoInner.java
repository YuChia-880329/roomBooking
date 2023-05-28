package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.SectionDto;
import springboot.bean.model.Section;
import springboot.dao.model.SectionDao;
import springboot.trans.model.SectionTrans;

@Repository("model.inner.SectionDaoInner")
public class SectionDaoInner extends DaoInner<Section, String, SectionDto, SectionTrans, SectionDao> {

	@Autowired
	@Qualifier("model.SectionDao")
	@Override
	public void setDao(SectionDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.SectionTrans")
	@Override
	public void setTrans(SectionTrans trans) {

		this.trans = trans;
	}
}

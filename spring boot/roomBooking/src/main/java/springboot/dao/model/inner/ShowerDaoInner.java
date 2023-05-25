package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.ShowerDto;
import springboot.bean.model.Shower;
import springboot.dao.model.ShowerDao;
import springboot.trans.model.ShowerTrans;

@Repository
public class ShowerDaoInner extends DaoInner<Shower, Integer, ShowerDto, ShowerTrans, ShowerDao> {

	@Autowired
	@Override
	public void setDao(ShowerDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(ShowerTrans trans) {

		this.trans = trans;
	}
}

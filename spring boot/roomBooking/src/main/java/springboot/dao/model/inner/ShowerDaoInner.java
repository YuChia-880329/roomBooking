package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.ShowerDto;
import springboot.bean.model.Shower;
import springboot.dao.model.ShowerDao;
import springboot.trans.model.ShowerTrans;

@Repository("model.inner.ShowerDaoInner")
public class ShowerDaoInner extends DaoInner<Shower, Integer, ShowerDto, ShowerTrans, ShowerDao> {

	public List<ShowerDto> findAllByOrderByIdAsc(){
		
		return trans.modelListToDtoList(dao.findAllByOrderByIdAsc());
	}
	
	
	@Autowired
	@Qualifier("model.ShowerDao")
	@Override
	public void setDao(ShowerDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.ShowerTrans")
	@Override
	public void setTrans(ShowerTrans trans) {

		this.trans = trans;
	}
}

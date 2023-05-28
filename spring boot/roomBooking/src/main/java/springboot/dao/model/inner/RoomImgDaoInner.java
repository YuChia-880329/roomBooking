package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.model.RoomImg;
import springboot.dao.model.RoomImgDao;
import springboot.trans.model.RoomImgTrans;

@Repository("model.inner.RoomImgDaoInner")
public class RoomImgDaoInner extends DaoInner<RoomImg, Integer, RoomImgDto, RoomImgTrans, RoomImgDao> {

	@Autowired
	@Qualifier("model.RoomImgDao")
	@Override
	public void setDao(RoomImgDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Qualifier("model.RoomImgTrans")
	@Override
	public void setTrans(RoomImgTrans trans) {

		this.trans = trans;
	}
}

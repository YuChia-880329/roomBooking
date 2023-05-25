package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.RoomImgDto;
import springboot.bean.model.RoomImg;
import springboot.dao.model.RoomImgDao;
import springboot.trans.model.RoomImgTrans;

@Repository
public class RoomImgDaoInner extends DaoInner<RoomImg, Integer, RoomImgDto, RoomImgTrans, RoomImgDao> {

	@Autowired
	@Override
	public void setDao(RoomImgDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(RoomImgTrans trans) {

		this.trans = trans;
	}
}

package springboot.dao.model.inner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import springboot.dao.model.RoomDao;
import springboot.trans.model.RoomTrans;

@Repository
public class RoomDaoInner extends DaoInner<Room, Integer, RoomDto, RoomTrans, RoomDao> {

	@Autowired
	@Override
	public void setDao(RoomDao dao) {

		this.dao = dao;
	}
	@Autowired
	@Override
	public void setTrans(RoomTrans trans) {

		this.trans = trans;
	}
}

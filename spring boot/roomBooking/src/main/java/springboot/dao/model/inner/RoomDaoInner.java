package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import springboot.dao.model.RoomDao;
import springboot.trans.model.RoomTrans;

@Repository
public class RoomDaoInner extends DaoInner<Room, Integer, RoomDto, RoomTrans, RoomDao> {

	
	public List<RoomDto> queryBkRoomListRoomTableRows(int hotelId, String nameQueryStr,
			String totalNumMinQueryStr, String totalNumMaxQueryStr,
			String usedNumMinQueryStr, String usedNumMaxQueryStr,
			String invalidNumMinQueryStr, String invalidNumMaxQueryStr,
			String priceMinQueryStr, String priceMaxQueryStr,
			String orderCol, String orderDirection,
			int rowNumMin, int rowNumMax){
		
		return trans.modelListToDtoList(
				dao.queryBkRoomListRoomTableRows(hotelId, nameQueryStr, 
						totalNumMinQueryStr, totalNumMaxQueryStr, usedNumMinQueryStr, usedNumMaxQueryStr, 
						invalidNumMinQueryStr, invalidNumMaxQueryStr, priceMinQueryStr, priceMaxQueryStr, 
						orderCol, orderDirection, rowNumMin, rowNumMax));
	}
	
	
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

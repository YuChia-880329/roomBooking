package springboot.dao.model.inner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.dto.model.RoomDto;
import springboot.dao.model.RoomDao;
import springboot.trans.model.RoomTrans;

@Repository("model.inner.RoomDaoInner")
public class RoomDaoInner {

	@Autowired
	@Qualifier("model.RoomDao")
	private RoomDao dao;
	@Autowired
	@Qualifier("model.RoomTrans")
	private RoomTrans trans;
	
	
	public Long queryBkRoomListRoomTableRowsRowNum(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax) {
		
		return dao.queryBkRoomListRoomTableRowsRowNum(hotelId, name, 
				totalNumMin, totalNumMax, usedNumMin, usedNumMax, 
				invalidNumMin, invalidNumMax, priceMin, priceMax);
	}
	public List<RoomDto> queryBkRoomListRoomTableRows(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax,
			RoomTableOrder roomTableOrder,
			int startRow, int maxRowNum){
		
		return trans.modelListToDtoList(
				dao.queryBkRoomListRoomTableRows(hotelId, name, 
						totalNumMin, totalNumMax, usedNumMin, usedNumMax, 
						invalidNumMin, invalidNumMax, priceMin, priceMax, 
						roomTableOrder, startRow, maxRowNum));
	}
}

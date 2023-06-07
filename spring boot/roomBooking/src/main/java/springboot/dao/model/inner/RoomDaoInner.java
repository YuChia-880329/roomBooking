package springboot.dao.model.inner;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import enumeration.RoomStatus;
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
	
	
	public Long queryBkRoomListTablePagesRowNum(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax, RoomStatus status) {
		
		return dao.queryBkRoomListTablePagesRowNum(hotelId, name, 
				totalNumMin, totalNumMax, usedNumMin, usedNumMax, 
				invalidNumMin, invalidNumMax, priceMin, priceMax, status);
	}
	public List<RoomDto> queryBkRoomListTablePages(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax, RoomStatus status,
			RoomTableOrder roomTableOrder,
			int startRow, int maxRowNum){
		
		return trans.modelListToDtoList(
				dao.queryBkRoomListTablePages(hotelId, name, 
						totalNumMin, totalNumMax, usedNumMin, usedNumMax, 
						invalidNumMin, invalidNumMax, priceMin, priceMax, 
						status, roomTableOrder, startRow, maxRowNum));
	}
	
	public List<RoomDto> queryAllRoomsByHotelId(int hotelId){
		
		return trans.modelListToDtoList(
				dao.queryAllRoomsByHotelId(hotelId));
	}
	
	public Optional<RoomDto> queryRoomById(int id){
		
		return dao.queryRoomById(id)
				.map(room -> trans.modelToDto(room));
	}
}

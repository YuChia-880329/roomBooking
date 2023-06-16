package springboot.dao.model.inner;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import enumeration.RoomStatus;
import enumeration.bk.roomList.RoomTableOrder;
import enumeration.fr.home.Num;
import springboot.bean.dto.model.RoomDto;
import springboot.bean.model.Room;
import springboot.bean.model.RoomImg;
import springboot.bean.model.Shower;
import springboot.dao.model.RoomDao;
import springboot.dao.model.RoomImgDao;
import springboot.trans.model.RoomTrans;

@Repository("model.inner.RoomDaoInner")
public class RoomDaoInner {

	@Autowired
	@Qualifier("model.RoomDao")
	private RoomDao dao;
	@Autowired
	@Qualifier("model.RoomImgDao")
	private RoomImgDao roomImgDao;
	
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
	public Long queryFrHotelRoomPagesCount(LocalDate checkinDate, LocalDate checkoutDate, Num num, String sectionCode){
		
		return dao.queryFrHotelRoomPagesCount(checkinDate, checkoutDate, num, sectionCode);
	}
	public List<RoomDto> queryFrHotelRoomPages(LocalDate checkinDate, LocalDate checkoutDate, Num num, String sectionCode, 
			int startRow, int maxRowNum){
		
		return trans.modelListToDtoList(dao.queryFrHotelRoomPages(checkinDate, checkoutDate, num, sectionCode, startRow, maxRowNum));
	}
	public Long queryFrRoomPagesCount(int hotelId, LocalDate checkinDate, LocalDate checkoutDate, Num num){
		
		return dao.queryFrRoomPagesCount(hotelId, checkinDate, checkoutDate, num);
	}
	public List<RoomDto> queryFrRoomPages(int hotelId, LocalDate checkinDate, LocalDate checkoutDate, Num num, 
			int startRow, int maxRowNum){
		
		return trans.modelListToDtoList(dao.queryFrRoomPages(hotelId, checkinDate, checkoutDate, num, startRow, maxRowNum));
	}
	public Long queryFrItemPagesCount(List<Integer> roomIds){
		
		return dao.queryFrItemPagesCount(roomIds);
	}
	public List<RoomDto> queryFrItemPages(List<Integer> roomIds, int startRow, int maxRowNum){
		
		return trans.modelListToDtoList(dao.queryFrItemPages(roomIds, startRow, maxRowNum));
	}
	
	
	@Transactional
	public RoomDto add(RoomDto room) {
		
		return trans.modelToDto(
				dao.add(
						trans.dtoToModel(room)));
	}
	
	@Transactional
	public RoomDto update(RoomDto room) {
		
		Room newRoom = trans.dtoToModel(room);
		Room oldRoom = dao.queryRoomById(newRoom.getId()).orElse(null);
		if(oldRoom == null)
			return null;
		
		oldRoom.setName(newRoom.getName());
		oldRoom.setTotalNum(newRoom.getTotalNum());
		oldRoom.setInvalidNum(newRoom.getInvalidNum());
		oldRoom.setPrice(newRoom.getPrice());
		oldRoom.setSingleBedNum(newRoom.getSingleBedNum());
		oldRoom.setDoubleBedNum(newRoom.getDoubleBedNum());
		oldRoom.setArea(newRoom.getArea());
		oldRoom.setSceneId(newRoom.getSceneId());
		oldRoom.setHotelId(newRoom.getHotelId());
		oldRoom.setStatus(newRoom.getStatus());
		
		List<Shower> showers = oldRoom.getShowers();
		showers.clear();
		showers.addAll(newRoom.getShowers());
		List<RoomImg> roomImgs = oldRoom.getRoomImgs();
		roomImgs.clear();
		newRoom.getRoomImgs().forEach(img -> {
			
			if(img.getId() == -1) {
				
				RoomImg oldImg = roomImgDao
						.queryByRoomIdAndOrder(img.getRoomId(), img.getImageOrder());
				if(oldImg != null)
					img.setId(oldImg.getId());
			}
		});
		roomImgs.addAll(newRoom.getRoomImgs());
		
		oldRoom.setShowers(showers);
		oldRoom.setRoomImgs(roomImgs);
		
		return trans.modelToDto(
				dao.update(oldRoom));
	}
}

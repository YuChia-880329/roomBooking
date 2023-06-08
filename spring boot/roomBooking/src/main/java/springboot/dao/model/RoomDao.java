package springboot.dao.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import enumeration.OrderDirection;
import enumeration.RoomStatus;
import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.model.Room;
import util.StringConcatUtil;

@Repository("model.RoomDao")
public class RoomDao {
	
	public static final String ID_ATTRIBUTE_NAME = "id";
	public static final String NAME_ATTRIBUTE_NAME = "name";
	public static final String TOTAL_NUM_ATTRIBUTE_NAME = "totalNum";
	public static final String INVALID_NUM_ATTRIBUTE_NAME = "invalidNum";
	public static final String USED_NUM_ATTRIBUTE_NAME = "usedNum";
	public static final String PRICE_ATTRIBUTE_NAME = "price";
	public static final String SINGLE_BED_NUM_ATTRIBUTE_NAME = "singleBedNum";
	public static final String DOUBLE_BED_NUM_ATTRIBUTE_NAME = "doubleBedNum";
	public static final String AREA_ATTRIBUTE_NAME = "area";
	public static final String SCENE_ID_ATTRIBUTE_NAME = "sceneId";
	public static final String HOTEL_ID_ATTRIBUTE_NAME = "hotelId";
	public static final String STATUS_ATTRIBUTE_NAME = "status";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long queryBkRoomListTablePagesRowNum(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax,
			RoomStatus status){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Room> root = criteriaQuery.from(Room.class);
		criteriaQuery.select(criteriaBuilder.count(root));
		
		Predicate[] predicates = queryBkRoomListTablePagesPredicate(hotelId, name, totalNumMin, totalNumMax, 
				usedNumMin, usedNumMax, invalidNumMin, invalidNumMax, priceMin, priceMax, status, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
	public List<Room> queryBkRoomListTablePages(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax, RoomStatus status,
			RoomTableOrder roomTableOrder,
			int startRow, int maxRowNum){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root =  criteriaQuery.from(Room.class);
		
		Predicate[] predicates = queryBkRoomListTablePagesPredicate(hotelId, name, totalNumMin, totalNumMax, 
				usedNumMin, usedNumMax, invalidNumMin, invalidNumMax, priceMin, priceMax, status, criteriaBuilder, root);
		criteriaQuery.where(predicates);

		criteriaQuery.orderBy(queryBkRoomListTablePagesOrder(roomTableOrder, criteriaBuilder, root));
		
		return entityManager.createQuery(criteriaQuery)
				.setFirstResult(startRow)
				.setMaxResults(maxRowNum)
				.getResultList();
	}
	
	public List<Room> queryAllRoomsByHotelId(int hotelId){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root =  criteriaQuery.from(Room.class);
		
		Predicate predicate = criteriaBuilder.equal(root.get(HOTEL_ID_ATTRIBUTE_NAME), hotelId);
		criteriaQuery.where(predicate);
		
		Order order = criteriaBuilder.asc(root.get(RoomTableOrder.NAME_ASC.getAttributeName()));
		criteriaQuery.orderBy(order);
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	public Optional<Room> queryRoomById(int id){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root =  criteriaQuery.from(Room.class);
		
		Predicate predicate = criteriaBuilder.equal(root.get(ID_ATTRIBUTE_NAME), id);
		criteriaQuery.where(predicate);
		
		Room room = null;
		List<Room> rooms = entityManager.createQuery(criteriaQuery).getResultList();
		room = rooms.size()>0 ? rooms.get(0) : null;
		return Optional.ofNullable(room);
	}
	public Room update(Room room) {
		
		return entityManager.merge(room);
	}
	
	
	
	private Predicate[] queryBkRoomListTablePagesPredicate(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax, RoomStatus status,
			CriteriaBuilder criteriaBuilder, Root<Room> root) {
		
		List<Predicate> predicateList = new ArrayList<>();
		predicateList.add(criteriaBuilder.equal(root.get(HOTEL_ID_ATTRIBUTE_NAME), hotelId));
		
		if(name != null)
			predicateList.add(criteriaBuilder.like(root.get(NAME_ATTRIBUTE_NAME), StringConcatUtil.concate("%", name, "%")));
		if(totalNumMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(TOTAL_NUM_ATTRIBUTE_NAME), totalNumMin));
		if(totalNumMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(TOTAL_NUM_ATTRIBUTE_NAME), totalNumMax));
		if(usedNumMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(USED_NUM_ATTRIBUTE_NAME), usedNumMin));
		if(usedNumMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(USED_NUM_ATTRIBUTE_NAME), usedNumMax));
		if(invalidNumMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(INVALID_NUM_ATTRIBUTE_NAME), invalidNumMin));
		if(invalidNumMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(INVALID_NUM_ATTRIBUTE_NAME), invalidNumMax));
		if(priceMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE_ATTRIBUTE_NAME), priceMin));
		if(priceMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(PRICE_ATTRIBUTE_NAME), priceMax));
		if(status != null)
			predicateList.add(criteriaBuilder.equal(root.get(STATUS_ATTRIBUTE_NAME), String.valueOf(status.getCode())));
		
		return predicateList.toArray(new Predicate[predicateList.size()]); 
	}
	
	private Order queryBkRoomListTablePagesOrder(RoomTableOrder roomTableOrder, 
			CriteriaBuilder criteriaBuilder, Root<Room> root) {
		
		if(roomTableOrder == null)
			roomTableOrder = RoomTableOrder.NAME_ASC;
		
		if(roomTableOrder.getDirection() == OrderDirection.ASC)
			return criteriaBuilder.asc(root.get(roomTableOrder.getAttributeName()));
		else
			return criteriaBuilder.desc(root.get(roomTableOrder.getAttributeName()));
	}
}




package springboot.dao.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.springframework.stereotype.Repository;

import enumeration.OrderDirection;
import enumeration.RoomStatus;
import enumeration.bk.roomList.RoomTableOrder;
import enumeration.fr.home.Num;
import springboot.bean.model.Room;
import util.DateTimeUtil;
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
	public static final String PEOPLE_NUM_ATTRIBUTE_NAME = "peopleNum";
	public static final String AREA_ATTRIBUTE_NAME = "area";
	public static final String SCENE_ID_ATTRIBUTE_NAME = "sceneId";
	public static final String HOTEL_ID_ATTRIBUTE_NAME = "hotelId";
	public static final String STATUS_ATTRIBUTE_NAME = "status";
	public static final String SCENE_ATTRIBUTE_NAME = "scene";
	public static final String HOTEL_ATTRIBUTE_NAME = "hotel";
	public static final String SHOWERS_ATTRIBUTE_NAME = "showers";
	public static final String ROOM_IMGS_ATTRIBUTE_NAME = "roomImgs";
	public static final String BOOKING_ORDERS_ATTRIBUTE_NAME = "bookingOrders";
	
	
	public static final String CHECKIN_DATE_ATTRIBUTE_NAME_BOOKING_ORDER = "checkinDate";
	public static final String CHECKOUT_DATE_ATTRIBUTE_NAME_BOOKING_ORDER = "checkoutDate";
	public static final String SECTION_CODE_ATTRIBUTE_NAME_HOTEL = "sectionCode";
	
	
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
	public Long queryFrontendHotelRoomsCount(LocalDate checkinDate, LocalDate checkoutDate, Num num, String sectionCode){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> mainQuery = criteriaBuilder.createQuery(Long.class);
		Root<Room> root = mainQuery.from(Room.class);
		
		Subquery<Room> subquery = mainQuery.subquery(Room.class);
		Root<Room> subRoot = subquery.from(Room.class);

		Join<Object, Object> joinBookingOrder = subRoot.join(BOOKING_ORDERS_ATTRIBUTE_NAME, JoinType.LEFT);
		Join<Object, Object> joinHotel = subRoot.join(HOTEL_ATTRIBUTE_NAME, JoinType.LEFT);
		
		subquery
			.select(subRoot)
			.where(queryFrontendHotelRoomsPredicates(checkinDate, checkoutDate, num, sectionCode, criteriaBuilder, 
					subRoot, joinBookingOrder, joinHotel));
		
		mainQuery
			.select(criteriaBuilder.count(root.get(ID_ATTRIBUTE_NAME)))
			.where(criteriaBuilder.in(root.get(ID_ATTRIBUTE_NAME)).value(subquery));
		
		TypedQuery<Long> tq = entityManager.createQuery(mainQuery);
		
		return tq.getSingleResult();
	}
	public List<Room> queryFrontendHotelRooms(LocalDate checkinDate, LocalDate checkoutDate, Num num, String sectionCode, int startRow, int maxRowNum){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> cq = criteriaBuilder.createQuery(Room.class);
		Root<Room> root = cq.from(Room.class);
		
		Join<Object, Object> joinBookingOrder = root.join(BOOKING_ORDERS_ATTRIBUTE_NAME, JoinType.LEFT);
		Join<Object, Object> joinHotel = root.join(HOTEL_ATTRIBUTE_NAME, JoinType.LEFT);
		
		cq.select(root)
			.where(queryFrontendHotelRoomsPredicates(checkinDate, checkoutDate, num, sectionCode, criteriaBuilder, root, joinBookingOrder, joinHotel))
			.orderBy(criteriaBuilder.asc(root.get(PEOPLE_NUM_ATTRIBUTE_NAME)), 
					criteriaBuilder.asc(root.get(PRICE_ATTRIBUTE_NAME)), 
					criteriaBuilder.asc(root.get(ID_ATTRIBUTE_NAME)));
		
		return entityManager.createQuery(cq)
				.setFirstResult(startRow)
				.setMaxResults(maxRowNum)
				.getResultList();
			
			
	}
	
	public Room add(Room room) {
		
		entityManager.persist(room);
		entityManager.flush();
		return room;
	}
	
	public Room update(Room room) {
		
		Room newRoom = entityManager.merge(room);
		entityManager.flush();
		return newRoom;
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
	
	
	private Predicate[] queryFrontendHotelRoomsPredicates(LocalDate checkinDate, LocalDate checkoutDate, Num num, 
			String sectionCode, CriteriaBuilder criteriaBuilder, Root<Room> root, Join<Object, Object> joinBookingOrder,
			Join<Object, Object> joinHotel){


		Predicate[] predicateArray = new Predicate[3];
		
		Predicate checkinPredicate = criteriaBuilder.greaterThanOrEqualTo(joinBookingOrder.get(CHECKIN_DATE_ATTRIBUTE_NAME_BOOKING_ORDER), DateTimeUtil.toDate(checkinDate));
		Predicate checkoutPredicate = criteriaBuilder.greaterThanOrEqualTo(joinBookingOrder.get(CHECKOUT_DATE_ATTRIBUTE_NAME_BOOKING_ORDER), DateTimeUtil.toDate(checkoutDate));
		Predicate checkinNullPredicate = criteriaBuilder.isNull(joinBookingOrder.get(CHECKIN_DATE_ATTRIBUTE_NAME_BOOKING_ORDER));
		Predicate checkoutNullPredicate = criteriaBuilder.isNull(joinBookingOrder.get(CHECKOUT_DATE_ATTRIBUTE_NAME_BOOKING_ORDER));
		
		predicateArray[0] = criteriaBuilder.or(checkinPredicate, checkoutPredicate, checkinNullPredicate, checkoutNullPredicate);
		predicateArray[1] = criteriaBuilder.greaterThanOrEqualTo(root.get(PEOPLE_NUM_ATTRIBUTE_NAME), num.getNumber());
		predicateArray[2] = criteriaBuilder.equal(joinHotel.get(SECTION_CODE_ATTRIBUTE_NAME_HOTEL), sectionCode);
		
		return predicateArray;
	}
}




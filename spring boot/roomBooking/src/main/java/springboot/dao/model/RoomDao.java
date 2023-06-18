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
import javax.persistence.criteria.Expression;
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
	
	
	public static final String ID_ATTRIBUTE_NAME_BOOKING_ORDER = "id";
	public static final String CHECKIN_DATE_ATTRIBUTE_NAME_BOOKING_ORDER = "checkinDate";
	public static final String CHECKOUT_DATE_ATTRIBUTE_NAME_BOOKING_ORDER = "checkoutDate";
	public static final String SECTION_CODE_ATTRIBUTE_NAME_HOTEL = "sectionCode";
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long queryBkRoomListTablePagesRowNum(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax,
			RoomStatus status){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Room> root = criteriaQuery.from(Room.class);
		criteriaQuery.select(criteriaBuilder.count(root));
		
		Predicate[] predicates = queryBkRoomListTablePagesPredicate(hotelId, name, totalNumMin, totalNumMax, 
				invalidNumMin, invalidNumMax, priceMin, priceMax, status, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
	public List<Room> queryBkRoomListTablePages(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax, RoomStatus status,
			RoomTableOrder roomTableOrder,
			int startRow, int maxRowNum){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root =  criteriaQuery.from(Room.class);
		
		Predicate[] predicates = queryBkRoomListTablePagesPredicate(hotelId, name, totalNumMin, totalNumMax, 
				invalidNumMin, invalidNumMax, priceMin, priceMax, status, criteriaBuilder, root);
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
	public Long queryFrHotelRoomPagesCount(LocalDate checkinDate, LocalDate checkoutDate, Num num, String sectionCode){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> mainQuery = criteriaBuilder.createQuery(Long.class);
		Root<Room> root = mainQuery.from(Room.class);
		
		Subquery<Room> subquery = mainQuery.subquery(Room.class);
		Root<Room> subRoot = subquery.from(Room.class);
		Join<Object, Object> joinBookingOrder = subRoot.join(BOOKING_ORDERS_ATTRIBUTE_NAME, JoinType.LEFT);
		subquery
			.select(subRoot)
			.where(queryFrHotelRoomPagesInnerWhere(checkinDate, checkoutDate, criteriaBuilder, subRoot, joinBookingOrder))
			.groupBy(subRoot.get(ID_ATTRIBUTE_NAME))
			.having(queryFrHotelRoomPagesInnerHaving(criteriaBuilder, subRoot, joinBookingOrder));
		
		
		Join<Object, Object> joinHotel = root.join(HOTEL_ATTRIBUTE_NAME);
		mainQuery
			.select(criteriaBuilder.count(root.get(ID_ATTRIBUTE_NAME)))
			.where(queryFrHotelRoomPagesOuterWhere(subquery, num, sectionCode, criteriaBuilder, root, joinHotel));
		
		TypedQuery<Long> tq = entityManager.createQuery(mainQuery);
		
		return tq.getSingleResult();
	}
	public List<Room> queryFrHotelRoomPages(LocalDate checkinDate, LocalDate checkoutDate, Num num, String sectionCode, int startRow, int maxRowNum){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> mainQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root = mainQuery.from(Room.class);
		
		Subquery<Room> subquery = mainQuery.subquery(Room.class);
		Root<Room> subRoot = subquery.from(Room.class);
		Join<Object, Object> joinBookingOrder = subRoot.join(BOOKING_ORDERS_ATTRIBUTE_NAME, JoinType.LEFT);
		subquery
			.select(subRoot)
			.where(queryFrHotelRoomPagesInnerWhere(checkinDate, checkoutDate, criteriaBuilder, subRoot, joinBookingOrder))
			.groupBy(subRoot.get(ID_ATTRIBUTE_NAME))
			.having(queryFrHotelRoomPagesInnerHaving(criteriaBuilder, subRoot, joinBookingOrder));
		
		Join<Object, Object> joinHotel = root.join(HOTEL_ATTRIBUTE_NAME);
		mainQuery
			.select(root)
			.where(queryFrHotelRoomPagesOuterWhere(subquery, num, sectionCode, criteriaBuilder, root, joinHotel))
			.orderBy(criteriaBuilder.asc(root.get(PEOPLE_NUM_ATTRIBUTE_NAME)), 
					criteriaBuilder.asc(root.get(PRICE_ATTRIBUTE_NAME)), 
					criteriaBuilder.asc(root.get(ID_ATTRIBUTE_NAME)));
		
		return entityManager.createQuery(mainQuery)
				.setFirstResult(startRow)
				.setMaxResults(maxRowNum)
				.getResultList();
	}

	public Long queryFrRoomPagesCount(int hotelId, LocalDate checkinDate, LocalDate checkoutDate, Num num){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> mainQuery = criteriaBuilder.createQuery(Long.class);
		Root<Room> root = mainQuery.from(Room.class);
		
		Subquery<Room> subquery = mainQuery.subquery(Room.class);
		Root<Room> subRoot = subquery.from(Room.class);
		Join<Object, Object> joinBookingOrder = subRoot.join(BOOKING_ORDERS_ATTRIBUTE_NAME, JoinType.LEFT);
		subquery
			.select(subRoot)
			.where(queryFrRoomPagesInnerWhere(checkinDate, checkoutDate, criteriaBuilder, subRoot, joinBookingOrder))
			.groupBy(subRoot.get(ID_ATTRIBUTE_NAME))
			.having(queryFrRoomPagesInnerHaving(criteriaBuilder, subRoot, joinBookingOrder));
		
		mainQuery
			.select(criteriaBuilder.count(root.get(ID_ATTRIBUTE_NAME)))
			.where(queryFrRoomPagesOuterWhere(subquery, num, hotelId, criteriaBuilder, root));
		
		TypedQuery<Long> tq = entityManager.createQuery(mainQuery);
		
		return tq.getSingleResult();
	}
	public List<Room> queryFrRoomPages(int hotelId, LocalDate checkinDate, LocalDate checkoutDate, Num num, int startRow, int maxRowNum){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> mainQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root = mainQuery.from(Room.class);
		
		Subquery<Room> subquery = mainQuery.subquery(Room.class);
		Root<Room> subRoot = subquery.from(Room.class);
		Join<Object, Object> joinBookingOrder = subRoot.join(BOOKING_ORDERS_ATTRIBUTE_NAME, JoinType.LEFT);
		subquery
			.select(subRoot)
			.where(queryFrRoomPagesInnerWhere(checkinDate, checkoutDate, criteriaBuilder, subRoot, joinBookingOrder))
			.groupBy(subRoot.get(ID_ATTRIBUTE_NAME))
			.having(queryFrRoomPagesInnerHaving(criteriaBuilder, subRoot, joinBookingOrder));
		
		mainQuery
			.select(root)
			.where(queryFrRoomPagesOuterWhere(subquery, num, hotelId, criteriaBuilder, root))
			.orderBy(criteriaBuilder.asc(root.get(PEOPLE_NUM_ATTRIBUTE_NAME)), 
					criteriaBuilder.asc(root.get(PRICE_ATTRIBUTE_NAME)), 
					criteriaBuilder.asc(root.get(ID_ATTRIBUTE_NAME)));
		
		return entityManager.createQuery(mainQuery)
				.setFirstResult(startRow)
				.setMaxResults(maxRowNum)
				.getResultList();
	}
	public List<Room> queryFrItemPages(List<Integer> roomIds){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root = criteriaQuery.from(Room.class);
		
		criteriaQuery.select(root)
			.where(criteriaBuilder.in(root.get(ID_ATTRIBUTE_NAME)).value(roomIds));
		
		return entityManager.createQuery(criteriaQuery)
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
	
	
	private Predicate queryFrHotelRoomPagesInnerWhere(LocalDate checkinDate, LocalDate checkoutDate, 
			CriteriaBuilder criteriaBuilder, Root<Room> root, Join<Object, Object> joinBookingOrder){


		Predicate checkinPredicate = criteriaBuilder.lessThan(joinBookingOrder.get(CHECKIN_DATE_ATTRIBUTE_NAME_BOOKING_ORDER), DateTimeUtil.toDate(checkoutDate));
		Predicate checkoutPredicate = criteriaBuilder.greaterThan(joinBookingOrder.get(CHECKOUT_DATE_ATTRIBUTE_NAME_BOOKING_ORDER), DateTimeUtil.toDate(checkinDate));
		
		return criteriaBuilder.and(checkinPredicate, checkoutPredicate);
	}
	private Predicate queryFrHotelRoomPagesInnerHaving(CriteriaBuilder criteriaBuilder, Root<Room> root, Join<Object, Object> joinBookingOrder){

		Expression<Number> totalNumEx = criteriaBuilder.max(root.get(TOTAL_NUM_ATTRIBUTE_NAME));
		Expression<Number> invalidNumEx = criteriaBuilder.max(root.get(INVALID_NUM_ATTRIBUTE_NAME));
		Expression<Long> bookingOrderNumEx = criteriaBuilder.count(joinBookingOrder.get(ID_ATTRIBUTE_NAME_BOOKING_ORDER));

		return criteriaBuilder.le(criteriaBuilder.diff(criteriaBuilder.diff(totalNumEx, invalidNumEx), bookingOrderNumEx), 0);
	}
	private Predicate queryFrHotelRoomPagesOuterWhere(Subquery<Room> subquery, Num num, String sectionCode, 
			CriteriaBuilder criteriaBuilder, Root<Room> root, Join<Object, Object> joinHotel){

		Predicate subqueryPredicate = criteriaBuilder.not(criteriaBuilder.in(root.get(ID_ATTRIBUTE_NAME)).value(subquery));
		Predicate numPredicate = criteriaBuilder.ge(root.get(PEOPLE_NUM_ATTRIBUTE_NAME), num.getNumber());
		Predicate sectionCodePredicate = criteriaBuilder.equal(joinHotel.get(SECTION_CODE_ATTRIBUTE_NAME_HOTEL), sectionCode);
		
		return criteriaBuilder.and(subqueryPredicate, numPredicate, sectionCodePredicate);
	}
	

	private Predicate queryFrRoomPagesInnerWhere(LocalDate checkinDate, LocalDate checkoutDate, 
			CriteriaBuilder criteriaBuilder, Root<Room> root, Join<Object, Object> joinBookingOrder){


		Predicate checkinPredicate = criteriaBuilder.lessThan(joinBookingOrder.get(CHECKIN_DATE_ATTRIBUTE_NAME_BOOKING_ORDER), DateTimeUtil.toDate(checkoutDate));
		Predicate checkoutPredicate = criteriaBuilder.greaterThan(joinBookingOrder.get(CHECKOUT_DATE_ATTRIBUTE_NAME_BOOKING_ORDER), DateTimeUtil.toDate(checkinDate));
		
		return criteriaBuilder.and(checkinPredicate, checkoutPredicate);
	}
	private Predicate queryFrRoomPagesInnerHaving(CriteriaBuilder criteriaBuilder, Root<Room> root, Join<Object, Object> joinBookingOrder){

		Expression<Number> totalNumEx = criteriaBuilder.max(root.get(TOTAL_NUM_ATTRIBUTE_NAME));
		Expression<Number> invalidNumEx = criteriaBuilder.max(root.get(INVALID_NUM_ATTRIBUTE_NAME));
		Expression<Long> bookingOrderNumEx = criteriaBuilder.count(joinBookingOrder.get(ID_ATTRIBUTE_NAME_BOOKING_ORDER));

		return criteriaBuilder.le(criteriaBuilder.diff(criteriaBuilder.diff(totalNumEx, invalidNumEx), bookingOrderNumEx), 0);
	}
	private Predicate queryFrRoomPagesOuterWhere(Subquery<Room> subquery, Num num, int hotelId, 
			CriteriaBuilder criteriaBuilder, Root<Room> root){

		Predicate subqueryPredicate = criteriaBuilder.not(criteriaBuilder.in(root.get(ID_ATTRIBUTE_NAME)).value(subquery));
		Predicate numPredicate = criteriaBuilder.ge(root.get(PEOPLE_NUM_ATTRIBUTE_NAME), num.getNumber());
		Predicate hotelIdPredicate = criteriaBuilder.equal(root.get(HOTEL_ID_ATTRIBUTE_NAME), hotelId);
		
		return criteriaBuilder.and(subqueryPredicate, numPredicate, hotelIdPredicate);
	}
}




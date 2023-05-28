package springboot.dao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import enumeration.OrderDirection;
import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.model.Room;
import util.StringConcatUtil;

@Repository("model.RoomDao")
public class RoomDao {
	
	public static final String ID_COL_NAME = "id";
	public static final String NAME_COL_NAME = "name";
	public static final String TOTAL_NUM_COL_NAME = "totalNum";
	public static final String INVALID_NUM_COL_NAME = "invalidNum";
	public static final String USED_NUM_COL_NAME = "usedNum";
	public static final String PRICE_COL_NAME = "price";
	public static final String SINGLE_BED_NUM_COL_NAME = "singleBedNum";
	public static final String DOUBLE_BED_NUM_COL_NAME = "doubleBedNum";
	public static final String AREA_COL_NAME = "area";
	public static final String SCENE_COL_NAME = "sceneId";
	public static final String HOTEL_COL_NAME = "hotelId";
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public Long queryBkRoomListRoomTableRowsRowNum(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
		
		Root<Room> root = criteriaQuery.from(Room.class);
		criteriaQuery.select(criteriaBuilder.count(root));
		
		Predicate[] predicates = queryBkRoomListRoomTableRowsPredicate(hotelId, name, totalNumMin, totalNumMax, 
				usedNumMin, usedNumMax, invalidNumMin, invalidNumMax, priceMin, priceMax, criteriaBuilder, root);
		criteriaQuery.where(predicates);
		
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}
	public List<Room> queryBkRoomListRoomTableRows(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax,
			RoomTableOrder roomTableOrder,
			int startRow, int maxRowNum){
		
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root =  criteriaQuery.from(Room.class);
		
		Predicate[] predicates = queryBkRoomListRoomTableRowsPredicate(hotelId, name, totalNumMin, totalNumMax, 
				usedNumMin, usedNumMax, invalidNumMin, invalidNumMax, priceMin, priceMax, criteriaBuilder, root);
		criteriaQuery.where(predicates);

		criteriaQuery.orderBy(queryBkRoomListRoomTableRowsOrder(roomTableOrder, criteriaBuilder, root));
		
		return entityManager.createQuery(criteriaQuery)
				.setFirstResult(startRow)
				.setMaxResults(maxRowNum)
				.getResultList();
	}
	
	private Predicate[] queryBkRoomListRoomTableRowsPredicate(
			int hotelId, String name,
			Integer totalNumMin, Integer totalNumMax,
			Integer usedNumMin, Integer usedNumMax,
			Integer invalidNumMin, Integer invalidNumMax,
			Integer priceMin, Integer priceMax,
			CriteriaBuilder criteriaBuilder, Root<Room> root) {
		
		List<Predicate> predicateList = new ArrayList<>();
		predicateList.add(criteriaBuilder.equal(root.get(HOTEL_COL_NAME), hotelId));
		
		if(name != null)
			predicateList.add(criteriaBuilder.like(root.get(NAME_COL_NAME), StringConcatUtil.concate("%", name, "%")));
		if(totalNumMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(TOTAL_NUM_COL_NAME), totalNumMin));
		if(totalNumMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(TOTAL_NUM_COL_NAME), totalNumMax));
		if(usedNumMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(USED_NUM_COL_NAME), usedNumMin));
		if(usedNumMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(USED_NUM_COL_NAME), usedNumMax));
		if(invalidNumMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(INVALID_NUM_COL_NAME), invalidNumMin));
		if(invalidNumMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(INVALID_NUM_COL_NAME), invalidNumMax));
		if(priceMin != null)
			predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE_COL_NAME), priceMin));
		if(priceMax != null)
			predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get(PRICE_COL_NAME), priceMax));
	
		return predicateList.toArray(new Predicate[predicateList.size()]); 
	}
	
	private Order queryBkRoomListRoomTableRowsOrder(RoomTableOrder roomTableOrder, 
			CriteriaBuilder criteriaBuilder, Root<Room> root) {
		
		if(roomTableOrder == null)
			roomTableOrder = RoomTableOrder.NAME_ASC;
		
		if(roomTableOrder.getDirection() == OrderDirection.ASC)
			return criteriaBuilder.asc(root.get(roomTableOrder.getAttributeName()));
		else
			return criteriaBuilder.desc(root.get(roomTableOrder.getAttributeName()));
	}
}




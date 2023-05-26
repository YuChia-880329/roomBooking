package springboot.dao.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import springboot.bean.model.Room;

public interface RoomDao extends JpaRepository<Room, Integer> {
	
	@Query(value = 
			"SELECT "
			+ "    NAME, TOTAL_NUM, USED_NUM, INVALID_NUM, PRICE"
			+ "FROM("
			+ "    SELECT"
			+ "        NAME, TOTAL_NUM, USED_NUM, INVALID_NUM, PRICE,"
			+ "        ROW_NUMBER()OVER(ORDER BY :orderCol :orderDirection) AS RN"
			+ "    FROM"
			+ "        room"
			+ "    WHERE"
			+ "        HOTEL_ID = :hotelId AND"
			+ "        NAME :name AND"
			+ "        TOTAL_NUM :totalNumMin AND TOTAL_NUM :totalNumMax AND"
			+ "        USED_NUM :usedNumMin AND USED_NUM :usedNumMax AND"
			+ "        INVALID_NUM :invalidNumMin AND INVALID_NUM :invalidNumMax AND"
			+ "        PRICE :priceMin AND PRICE :priceMax"
			+ ")"
			+ "WHERE RN BETWEEN :rowNumMin AND :rowNumMax", 
			nativeQuery = true)
	public List<Room> queryBkRoomListRoomTableRows(
			@Param("hotelId") int hotelId, @Param("name") String nameQueryStr,
			@Param("totalNumMin") String totalNumMinQueryStr, @Param("totalNumMax") String totalNumMaxQueryStr,
			@Param("usedNumMin") String usedNumMinQueryStr, @Param("usedNumMax") String usedNumMaxQueryStr,
			@Param("invalidNumMin") String invalidNumMinQueryStr, @Param("invalidNumMax") String invalidNumMaxQueryStr,
			@Param("priceMin") String priceMinQueryStr, @Param("priceMax") String priceMaxQueryStr,
			@Param("orderCol") String orderCol, @Param("orderDirection") String orderDirection,
			@Param("rowNumMin") int rowNumMin, @Param("rowNumMax") int rowNumMax);
}

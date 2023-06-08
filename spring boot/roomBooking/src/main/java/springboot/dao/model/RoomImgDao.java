package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.bean.model.RoomImg;

@Repository("model.RoomImgDao")
public interface RoomImgDao extends JpaRepository<RoomImg, Integer> {
	
	@Query("SELECT ri FROM RoomImg ri WHERE ri.roomId = :roomId AND ri.imageOrder = :order")
	public RoomImg queryByRoomIdAndOrder(@Param("roomId") int roomId, @Param("order") int order);
}

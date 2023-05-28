package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.RoomImg;

@Repository("model.RoomImgDao")
public interface RoomImgDao extends JpaRepository<RoomImg, Integer> {
}

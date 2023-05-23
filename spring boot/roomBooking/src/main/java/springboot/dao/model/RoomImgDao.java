package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.RoomImg;

public interface RoomImgDao extends JpaRepository<RoomImg, Integer> {
}

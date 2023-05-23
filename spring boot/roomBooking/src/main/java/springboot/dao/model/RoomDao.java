package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.Room;

public interface RoomDao extends JpaRepository<Room, Integer> {
}

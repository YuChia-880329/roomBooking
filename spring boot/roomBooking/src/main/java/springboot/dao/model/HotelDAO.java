package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.Hotel;

public interface HotelDAO extends JpaRepository<Hotel, Integer> {

}

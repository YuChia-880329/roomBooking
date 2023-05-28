package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Hotel;

@Repository("model.HotelDao")
public interface HotelDao extends JpaRepository<Hotel, Integer> {
}

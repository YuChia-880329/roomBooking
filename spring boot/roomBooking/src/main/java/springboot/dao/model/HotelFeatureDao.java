package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.HotelFeature;

@Repository("model.HotelFeatureDao")
public interface HotelFeatureDao extends JpaRepository<HotelFeature, Integer> {
}

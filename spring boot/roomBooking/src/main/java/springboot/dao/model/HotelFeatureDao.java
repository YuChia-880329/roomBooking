package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.HotelFeature;

public interface HotelFeatureDao extends JpaRepository<HotelFeature, Integer> {
}

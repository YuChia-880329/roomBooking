package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.bean.model.HotelFeature;

@Repository("model.HotelFeatureDao")
public interface HotelFeatureDao extends JpaRepository<HotelFeature, Integer> {

	@Query("SELECT h FROM HotelFeature h WHERE h.name=:name")
	public HotelFeature queryByName(@Param("name") String name);
}

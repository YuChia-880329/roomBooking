package springboot.dao.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.NewFeature;

@Repository("model.NewFeatureDao")
public interface NewFeatureDao extends JpaRepository<NewFeature, Integer> {
	
	public List<NewFeature> findByHotelId(int hotelId);
	
	public List<NewFeature> findByNameAndHotelId(String name, int hotelId);
}

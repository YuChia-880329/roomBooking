package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Feature;

@Repository("model.FeatureDao")
public interface FeatureDao extends JpaRepository<Feature, Integer> {

	@Query("SELECT h FROM Feature h WHERE h.name=:name")
	public Feature queryByName(@Param("name") String name);
}

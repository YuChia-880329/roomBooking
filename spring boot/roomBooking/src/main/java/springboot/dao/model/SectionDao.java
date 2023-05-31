package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Section;

@Repository("model.SectionDao")
public interface SectionDao extends JpaRepository<Section, String> {

}

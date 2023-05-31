package springboot.dao.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Section;

@Repository("model.SectionDao")
public interface SectionDao extends JpaRepository<Section, String> {

	public List<Section> findAll();
}

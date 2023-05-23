package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.Section;

public interface SectionDao extends JpaRepository<Section, String> {
}

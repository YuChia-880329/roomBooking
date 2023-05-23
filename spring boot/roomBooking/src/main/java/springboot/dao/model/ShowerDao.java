package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.Shower;

public interface ShowerDao extends JpaRepository<Shower, Integer> {
}

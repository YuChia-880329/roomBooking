package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.Shower;

@Repository("model.ShowerDao")
public interface ShowerDao extends JpaRepository<Shower, Integer> {
}

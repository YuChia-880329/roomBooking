package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.PayMethod;

@Repository("model.PayMethodDao")
public interface PayMethodDao extends JpaRepository<PayMethod, Integer> {
}

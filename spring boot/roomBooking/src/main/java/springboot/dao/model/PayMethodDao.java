package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.PayMethod;

public interface PayMethodDao extends JpaRepository<PayMethod, Integer> {
}

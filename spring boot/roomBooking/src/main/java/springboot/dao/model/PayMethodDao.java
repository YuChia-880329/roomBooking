package springboot.dao.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import springboot.bean.model.PayMethod;

@Repository("model.PayMethodDao")
public interface PayMethodDao extends JpaRepository<PayMethod, Integer> {
	
	@Query("SELECT p FROM PayMethod p")
	public List<PayMethod> queryAllPayMethods();
}

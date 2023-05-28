package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.bean.model.HotelAccount;

@Repository("model.HotelAccountDao")
public interface HotelAccountDao extends JpaRepository<HotelAccount, Integer> {
	
	public HotelAccount findFirstByAccount(String account);
}

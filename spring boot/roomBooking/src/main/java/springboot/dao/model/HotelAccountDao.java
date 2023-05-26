package springboot.dao.model;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.bean.model.HotelAccount;

public interface HotelAccountDao extends JpaRepository<HotelAccount, Integer> {
	
	public HotelAccount findFirstByAccount(String account);
}

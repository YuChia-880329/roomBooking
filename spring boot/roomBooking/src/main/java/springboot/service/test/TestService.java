package springboot.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.model.Hotel;
import springboot.dao.model.HotelDAO;

@Service
public class TestService {

	@Autowired
	private HotelDAO hotelDAO;
	
	
	public List<Hotel> findAllHotel(){
		
		return hotelDAO.findAll();
	}
}

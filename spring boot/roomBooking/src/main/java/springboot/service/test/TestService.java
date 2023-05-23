package springboot.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springboot.bean.model.BookingOrder;
import springboot.bean.model.Hotel;
import springboot.bean.model.HotelAccount;
import springboot.bean.model.HotelFeature;
import springboot.bean.model.Member;
import springboot.bean.model.PayMethod;
import springboot.bean.model.Room;
import springboot.bean.model.RoomImg;
import springboot.bean.model.Scene;
import springboot.bean.model.Section;
import springboot.bean.model.Shower;
import springboot.dao.model.BookingOrderDao;
import springboot.dao.model.HotelAccountDao;
import springboot.dao.model.HotelDao;
import springboot.dao.model.HotelFeatureDao;
import springboot.dao.model.MemberDao;
import springboot.dao.model.PayMethodDao;
import springboot.dao.model.RoomDao;
import springboot.dao.model.RoomImgDao;
import springboot.dao.model.SceneDao;
import springboot.dao.model.SectionDao;
import springboot.dao.model.ShowerDao;

@Service
public class TestService {

	@Autowired
	private BookingOrderDao bookingOrderDao;
	@Autowired
	private HotelAccountDao hotelAccountDao;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private HotelFeatureDao hotelFeatureDao;
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private PayMethodDao payMethodDao;
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private RoomImgDao roomImgDao;
	@Autowired
	private SceneDao sceneDao;
	@Autowired
	private SectionDao sectionDao;
	@Autowired
	private ShowerDao showerDao;
	
	
	public List<BookingOrder> findAllBookingOrder(){
		
		return bookingOrderDao.findAll();
	}
	public List<HotelAccount> findAllHotelAccount(){
		
		return hotelAccountDao.findAll();
	}
	public List<Hotel> findAllHotel(){
		
		return hotelDao.findAll();
	}
	public List<HotelFeature> findAllHotelFeature(){
		
		return hotelFeatureDao.findAll();
	}
	public List<Member> findAllMember(){
		
		return memberDao.findAll();
	}
	public List<PayMethod> findAllPayMethod(){
		
		return payMethodDao.findAll();
	}
	public List<Room> findAllRoom(){
		
		return roomDao.findAll();
	}
	public List<RoomImg> findAllRoomImg(){
		
		return roomImgDao.findAll();
	}
	public List<Scene> findAllScene(){
		
		return sceneDao.findAll();
	}
	public List<Section> findAllSection(){
		
		return sectionDao.findAll();
	}
	public List<Shower> findAllShower(){
		
		return showerDao.findAll();
	}
}

package springboot.service.fr.home.memory.repo.hotelRoomPages;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import enumeration.fr.home.Num;
import springboot.bean.obj.fr.home.repo.hotelRoomPages.SearchParam;
import util.SearchParamUtil;

@Service("fr.home.memory.repo.hotelRoomPages.SearchParamService")
public class SearchParamService {

	public boolean equals(SearchParam searchParam1, SearchParam searchParam2) {

		return checkinDateEquals(searchParam1.getCheckinDate(), searchParam2.getCheckinDate()) && 
				checkoutDateEquals(searchParam1.getCheckoutDate(), searchParam2.getCheckoutDate()) &&
				numEquals(searchParam1.getNum(), searchParam2.getNum()) &&
				sectionCodeEquals(searchParam1.getSectionCode(), searchParam2.getSectionCode());
	}
	
	private boolean checkinDateEquals(LocalDate checkinDate1, LocalDate checkinDate2) {
		
		return SearchParamUtil.equals(checkinDate1, checkinDate2, (t1, t2) -> t1.equals(t2));
	}
	private boolean checkoutDateEquals(LocalDate checkoutDate1, LocalDate checkoutDate2) {
		
		return SearchParamUtil.equals(checkoutDate1, checkoutDate2, (t1, t2) -> t1.equals(t2));
	}
	private boolean numEquals(Num num1, Num num2) {
		
		return SearchParamUtil.equals(num1, num2, (t1, t2) -> t1==t2);
	}
	private boolean sectionCodeEquals(String sectionCode1, String sectionCode2) {
		
		return SearchParamUtil.equals(sectionCode1, sectionCode2, (t1, t2) -> t1.equals(t2));
	}
}

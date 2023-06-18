package springboot.service.bk.bookingOrderList.memory.repo.tablePages;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import enumeration.bk.bookingOderList.BookingOrderTableOrder;
import springboot.bean.obj.bk.bookingOrderList.repo.tablePages.SearchParam;
import util.SearchParamUtil;

@Service("bk.bookingOrderList.memory.repo.tablePages.SearchParamService")
public class SearchParamService {

	public boolean equals(SearchParam searchParam1, SearchParam searchParam2) {

		return idMinEquals(searchParam1.getIdMin(), searchParam2.getIdMin()) &&
				idMaxEquals(searchParam1.getIdMax(), searchParam2.getIdMax()) &&
				clientNameEquals(searchParam1.getClientName(), searchParam2.getClientName()) &&
				clientPhoneEquals(searchParam1.getClientPhone(), searchParam2.getClientPhone()) &&
				roomTypeEquals(searchParam1.getRoomType(), searchParam2.getRoomType()) &&
				roomNumMinEquals(searchParam1.getRoomNumMin(), searchParam2.getRoomNumMin()) &&
				roomNumMaxEquals(searchParam1.getRoomNumMax(), searchParam2.getRoomNumMax()) &&
				priceMinEquals(searchParam1.getPriceMin(), searchParam2.getPriceMin()) &&
				priceMaxEquals(searchParam1.getPriceMax(), searchParam2.getPriceMax()) &&
				payMethodIdsEquals(searchParam1.getPayMethodIds(), searchParam2.getPayMethodIds()) &&
				checkinDateFromEquals(searchParam1.getCheckinDateFrom(), searchParam2.getCheckinDateFrom()) &&
				checkinDateToEquals(searchParam1.getCheckinDateTo(), searchParam2.getCheckinDateTo()) &&
				checkoutDateFromEquals(searchParam1.getCheckoutDateFrom(), searchParam2.getCheckoutDateFrom()) &&
				checkoutDateToEquals(searchParam1.getCheckoutDateTo(), searchParam2.getCheckoutDateTo()) &&
				useDayMinEquals(searchParam1.getUseDayMin(), searchParam2.getUseDayMin()) &&
				useDayMaxEquals(searchParam1.getUseDayMax(), searchParam2.getUseDayMax()) &&
				totalPriceMinEquals(searchParam1.getTotalPriceMin(), searchParam2.getTotalPriceMin()) &&
				totalPriceMaxEquals(searchParam1.getTotalPriceMax(), searchParam2.getTotalPriceMax()) &&
				bookingOrderTableOrderEquals(searchParam1.getBookingOrderTableOrder(), searchParam2.getBookingOrderTableOrder());
	}
	

	private boolean idMinEquals(Integer idMin1, Integer idMin2) {
		
		return SearchParamUtil.equals(idMin1, idMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean idMaxEquals(Integer idMax1, Integer idMax2) {
		
		return SearchParamUtil.equals(idMax1, idMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean clientNameEquals(String clientName1, String clientName2) {
		
		return SearchParamUtil.equals(clientName1, clientName2, (t1, t2) -> t1.equals(t2));
	}
	private boolean clientPhoneEquals(String clientPhone1, String clientPhone2) {
		
		return SearchParamUtil.equals(clientPhone1, clientPhone2, (t1, t2) -> t1.equals(t2));
	}
	private boolean roomTypeEquals(Integer roomType1, Integer roomType2) {
		
		return SearchParamUtil.equals(roomType1, roomType2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean roomNumMinEquals(Integer roomNumMin1, Integer roomNumMin2) {
		
		return SearchParamUtil.equals(roomNumMin1, roomNumMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean roomNumMaxEquals(Integer roomNumMax1, Integer roomNumMax2) {
		
		return SearchParamUtil.equals(roomNumMax1, roomNumMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean priceMinEquals(Integer priceMin1, Integer priceMin2) {
		
		return SearchParamUtil.equals(priceMin1, priceMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean priceMaxEquals(Integer priceMax1, Integer priceMax2) {
		
		return SearchParamUtil.equals(priceMax1, priceMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean payMethodIdsEquals(List<Integer> payMethodIds1, List<Integer> payMethodIds2) {
		
		return SearchParamUtil.equals(payMethodIds1, payMethodIds2, (t1, t2) -> {
			
			if(t1.size() != t2.size())
				return false;
			
			for(int i=0; i<t1.size(); i++) {
				
				if(t1.get(i) != t2.get(i))
					return false;
			}
			return true;
		});
	}
	private boolean checkinDateFromEquals(LocalDate checkinDateFrom1, LocalDate checkinDateFrom2) {
		
		return SearchParamUtil.equals(checkinDateFrom1, checkinDateFrom2, (t1, t2) -> t1.equals(t2));
	}
	private boolean checkinDateToEquals(LocalDate checkinDateTo1, LocalDate checkinDateTo2) {
		
		return SearchParamUtil.equals(checkinDateTo1, checkinDateTo2, (t1, t2) -> t1.equals(t2));
	}
	private boolean checkoutDateFromEquals(LocalDate checkoutDateFrom1, LocalDate checkoutDateFrom2) {
		
		return SearchParamUtil.equals(checkoutDateFrom1, checkoutDateFrom2, (t1, t2) -> t1.equals(t2));
	}
	private boolean checkoutDateToEquals(LocalDate checkoutDateTo1, LocalDate checkoutDateTo2) {
		
		return SearchParamUtil.equals(checkoutDateTo1, checkoutDateTo2, (t1, t2) -> t1.equals(t2));
	}
	private boolean useDayMinEquals(Integer useDayMin1, Integer useDayMin2) {
		
		return SearchParamUtil.equals(useDayMin1, useDayMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean useDayMaxEquals(Integer useDayMax1, Integer useDayMax2) {
		
		return SearchParamUtil.equals(useDayMax1, useDayMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean totalPriceMinEquals(Integer totalPriceMin1, Integer totalPriceMin2) {
		
		return SearchParamUtil.equals(totalPriceMin1, totalPriceMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean totalPriceMaxEquals(Integer totalPriceMax1, Integer totalPriceMax2) {
		
		return SearchParamUtil.equals(totalPriceMax1, totalPriceMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean bookingOrderTableOrderEquals(BookingOrderTableOrder bookingOrderTableOrder1, BookingOrderTableOrder bookingOrderTableOrder2) {
		
		return SearchParamUtil.equals(bookingOrderTableOrder1, bookingOrderTableOrder2, (t1, t2) -> t1==t2);
	}
}

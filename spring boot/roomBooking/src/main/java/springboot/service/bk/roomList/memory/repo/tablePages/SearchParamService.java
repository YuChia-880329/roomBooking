package springboot.service.bk.roomList.memory.repo.tablePages;

import org.springframework.stereotype.Service;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.obj.bk.roomList.repo.tablePages.SearchParam;
import util.SearchParamUtil;

@Service("bk.roomList.memory.repo.tablePages.SearchParamService")
public class SearchParamService {

	public boolean equals(SearchParam searchParam1, SearchParam searchParam2) {

		return nameEquals(searchParam1.getName(), searchParam2.getName()) && 
				totalNumMinEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMin()) &&
				totalNumMaxEquals(searchParam1.getTotalNumMax(), searchParam2.getTotalNumMax()) &&
				usedNumMinEquals(searchParam1.getUsedNumMin(), searchParam2.getUsedNumMin()) &&
				usedNumMaxEquals(searchParam1.getUsedNumMax(), searchParam2.getUsedNumMin()) &&
				invalidNumMinEquals(searchParam1.getInvalidNumMin(), searchParam2.getInvalidNumMin()) &&
				invalidNumMaxEquals(searchParam1.getInvalidNumMax(), searchParam2.getInvalidNumMax()) &&
				priceMinEquals(searchParam1.getPriceMin(), searchParam2.getPriceMin()) &&
				priceMaxEquals(searchParam1.getPriceMax(), searchParam2.getPriceMax()) &&
				roomTableOrderEquals(searchParam1.getRoomTableOrder(), searchParam2.getRoomTableOrder());	
	}
	
	private boolean nameEquals(String name1, String name2) {
		
		return SearchParamUtil.equals(name1, name2, (t1, t2) -> t1.equals(t2));
	}
	private boolean totalNumMinEquals(Integer totalNumMin1, Integer totalNumMin2) {
		
		return SearchParamUtil.equals(totalNumMin1, totalNumMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean totalNumMaxEquals(Integer totalNumMax1, Integer totalNumMax2) {
		
		return SearchParamUtil.equals(totalNumMax1, totalNumMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean usedNumMinEquals(Integer usedNumMin1, Integer usedNumMin2) {
		
		return SearchParamUtil.equals(usedNumMin1, usedNumMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean usedNumMaxEquals(Integer usedNumMax1, Integer usedNumMax2) {
		
		return SearchParamUtil.equals(usedNumMax1, usedNumMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean invalidNumMinEquals(Integer invalidNumMin1, Integer invalidNumMin2) {
		
		return SearchParamUtil.equals(invalidNumMin1, invalidNumMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean invalidNumMaxEquals(Integer invalidNumMax1, Integer invalidNumMax2) {
		
		return SearchParamUtil.equals(invalidNumMax1, invalidNumMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean priceMinEquals(Integer priceMin1, Integer priceMin2) {
		
		return SearchParamUtil.equals(priceMin1, priceMin2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean priceMaxEquals(Integer priceMax1, Integer priceMax2) {
		
		return SearchParamUtil.equals(priceMax1, priceMax2, (t1, t2) -> t1.intValue()==t2.intValue());
	}
	private boolean roomTableOrderEquals(RoomTableOrder roomTableOrder1, RoomTableOrder roomTableOrder2) {
		
		return roomTableOrder1 == roomTableOrder2;
	}
}

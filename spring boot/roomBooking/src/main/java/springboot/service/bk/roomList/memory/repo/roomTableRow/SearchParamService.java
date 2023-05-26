package springboot.service.bk.roomList.memory.repo.roomTableRow;

import org.springframework.stereotype.Service;

import enumeration.bk.roomList.RoomTableOrder;
import springboot.bean.obj.bk.roomList.repo.roomTableRows.SearchParam;
import util.SearchParamUtil;

@Service
public class SearchParamService {

	public boolean equals(SearchParam searchParam1, SearchParam searchParam2) {

		return nameEquals(searchParam1.getName(), searchParam2.getName()) && 
				totalNumMinEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				totalNumMaxEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				usedNumMinEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				usedNumMaxEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				invalidNumMinEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				invalidNumMaxEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				priceMinEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				priceMaxEquals(searchParam1.getTotalNumMin(), searchParam2.getTotalNumMax()) &&
				roomTableOrderEquals(searchParam1.getRoomTableOrder(), searchParam2.getRoomTableOrder());	
	}
	
	
	public String nameQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStr(searchParam.getName());
	}
	public String totalNumMinQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMin(searchParam.getTotalNumMin());
	}
	public String totalNumMaxQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMax(searchParam.getTotalNumMax());
	}
	public String usedNumMinQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMin(searchParam.getUsedNumMin());
	}
	public String usedNumMaxQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMax(searchParam.getUsedNumMax());
	}
	public String invalidNumMinQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMin(searchParam.getInvalidNumMin());
	}
	public String invalidNumMaxQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMax(searchParam.getInvalidNumMax());
	}
	public String priceMinQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMin(searchParam.getPriceMin());
	}
	public String priceMaxQueryStr(SearchParam searchParam) {
		
		return SearchParamUtil.queryStrMax(searchParam.getPriceMax());
	}
	
	
	
	
	private boolean nameEquals(String name1, String name2) {
		
		return name1.equals(name2);
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

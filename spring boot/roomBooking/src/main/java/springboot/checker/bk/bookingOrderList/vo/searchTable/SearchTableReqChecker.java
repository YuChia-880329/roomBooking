package springboot.checker.bk.bookingOrderList.vo.searchTable;

import org.springframework.stereotype.Component;

import exception.check.NonIntegerNumberException;
import exception.check.NonNumberStringException;
import springboot.bean.vo.bk.bookingOrderList.searchTable.SearchTableReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.bookingOrderList.vo.searchTable.SearchTableReqChecker")
public class SearchTableReqChecker implements Checker<SearchTableReq> {

	public static final String ID_MIN_FIELD_NAME = "訂單編號(最小值)";
	public static final String ID_MAX_FIELD_NAME = "訂單編號(最大值)";
	public static final String ROOM_TYPE_FIELD_NAME = "預定房型";
	public static final String ROOM_NUM_MIN_FIELD_NAME = "預定房間數(最小值)";
	public static final String ROOM_NUM_MAX_FIELD_NAME = "預定房間數(最大值)";
	public static final String PRICE_MIN_FIELD_NAME = "房型單價(最小值)";
	public static final String PRICE_MAX_FIELD_NAME = "房型單價(最大值)";
	public static final String PAY_METHOD_FIELD_NAME = "付款方式";
	public static final String CHECKIN_DATE_FROM_FIELD_NAME = "預定入住日期(起)";
	public static final String CHECKIN_DATE_TO_FIELD_NAME = "預定入住日期(迄)";
	public static final String CHECKOUT_DATE_FROM_FIELD_NAME = "預定退房日期(起)";
	public static final String CHECKOUT_DATE_TO_FIELD_NAME = "預定退房日期(迄)";
	public static final String USE_DAY_MIN_FIELD_NAME = "入住天數(最小值)";
	public static final String USE_DAY_MAX_FIELD_NAME = "入住天數(最大值)";
	public static final String TOTAL_PRICE_MIN_FIELD_NAME = "總金額(最小值)";
	public static final String TOTAL_PRICE_MAX_FIELD_NAME = "總金額(最大值)";
	
	@Override
	public void check(SearchTableReq vo) {
		
		checkVo(vo);
		
		checkIdMin(vo);
		checkIdMax(vo);
		checkClientName(vo);
		checkClientPhone(vo);
		checkRoomType(vo);
		checkRoomNumMin(vo);
		checkRoomNumMax(vo);
		checkPriceMin(vo);
		checkPriceMax(vo);
		checkPayMethod(vo);
		checkCheckinDateFrom(vo);
		checkCheckinDateTo(vo);
		checkCheckoutDateFrom(vo);
		checkCheckoutDateTo(vo);
		checkUseDayMin(vo);
		checkUseDayMax(vo);
		checkTotalPriceMin(vo);
		checkTotalPriceMax(vo);
	}
	
	private void checkVo(SearchTableReq vo) {
		
		CheckUtil.checkOther(vo);
	}

	private void checkIdMin(SearchTableReq vo) {
		
		String idMin = vo.getIdMin();
		if(idMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(idMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(ID_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(ID_MIN_FIELD_NAME));
		}
	}
	private void checkIdMax(SearchTableReq vo) {
		
		String idMax = vo.getIdMax();
		if(idMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(idMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(ID_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(ID_MAX_FIELD_NAME));
		}
	}
	private void checkClientName(SearchTableReq vo) {
	}
	private void checkClientPhone(SearchTableReq vo) {
	}
	private void checkRoomType(SearchTableReq vo) {
		
		String roomType = vo.getRoomType();
		if(roomType == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(roomType);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(ROOM_TYPE_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(ROOM_TYPE_FIELD_NAME));
		}
	}
	private void checkRoomNumMin(SearchTableReq vo) {
		
		String roomNumMin = vo.getRoomNumMin();
		if(roomNumMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(roomNumMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(ROOM_NUM_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(ROOM_NUM_MIN_FIELD_NAME));
		}
	}
	private void checkRoomNumMax(SearchTableReq vo) {
		
		String roomNumMax = vo.getRoomNumMax();
		if(roomNumMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(roomNumMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(ROOM_NUM_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(ROOM_NUM_MAX_FIELD_NAME));
		}
	}
	private void checkPriceMin(SearchTableReq vo) {
		
		String priceMin = vo.getPriceMin();
		if(priceMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(priceMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(PRICE_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(PRICE_MIN_FIELD_NAME));
		}
	}
	private void checkPriceMax(SearchTableReq vo) {
		
		String priceMax = vo.getPriceMax();
		if(priceMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(priceMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(PRICE_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(PRICE_MAX_FIELD_NAME));
		}
	}
	private void checkPayMethod(SearchTableReq vo) {
	}
	private void checkCheckinDateFrom(SearchTableReq vo) {
	}
	private void checkCheckinDateTo(SearchTableReq vo) {
	}
	private void checkCheckoutDateFrom(SearchTableReq vo) {
	}
	private void checkCheckoutDateTo(SearchTableReq vo) {
	}
	private void checkUseDayMin(SearchTableReq vo) {
		
		String useDayMin = vo.getUseDayMin();
		if(useDayMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(useDayMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(USE_DAY_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(USE_DAY_MIN_FIELD_NAME));
		}
	}
	private void checkUseDayMax(SearchTableReq vo) {
		
		String useDayMax = vo.getUseDayMax();
		if(useDayMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(useDayMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(USE_DAY_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(USE_DAY_MAX_FIELD_NAME));
		}
	}
	
	
	private void checkTotalPriceMin(SearchTableReq vo) {
		
		String totalPriceMin = vo.getTotalPriceMin();
		if(totalPriceMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(totalPriceMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(TOTAL_PRICE_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(TOTAL_PRICE_MIN_FIELD_NAME));
		}
	}
	private void checkTotalPriceMax(SearchTableReq vo) {
		
		String totalPriceMax = vo.getTotalPriceMax();
		if(totalPriceMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(totalPriceMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(TOTAL_PRICE_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(TOTAL_PRICE_MAX_FIELD_NAME));
		}
	}
}

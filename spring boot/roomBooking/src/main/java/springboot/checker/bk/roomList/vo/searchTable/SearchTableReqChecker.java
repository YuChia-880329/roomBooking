package springboot.checker.bk.roomList.vo.searchTable;

import org.springframework.stereotype.Component;

import enumeration.RoomStatus;
import exception.check.NonIntegerNumberException;
import exception.check.NonNumberStringException;
import exception.check.StringIsNotOneOfException;
import springboot.bean.vo.bk.roomList.searchTable.SearchTableReq;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.roomList.vo.searchTable.SearchTableReqChecker")
public class SearchTableReqChecker implements Checker<SearchTableReq> {

	public static final String TOTAL_NUM_MIN_FIELD_NAME = "總房數(最小值)";
	public static final String TOTAL_NUM_MAX_FIELD_NAME = "總房數(最大值)";
	public static final String INVALID_NUM_MIN_FIELD_NAME = "不開放房數(最小值)";
	public static final String INVALID_NUM_MAX_FIELD_NAME = "不開放房數(最大值)";
	public static final String PRICE_MIN_FIELD_NAME = "房間單價(最小值)";
	public static final String PRICE_MAX_FIELD_NAME = "房間單價(最大值)";
	public static final String STATUS_FIELD_NAME = "房間狀態";
	
	@Override
	public void check(SearchTableReq vo) {
		
		checkVo(vo);
		
		checkName(vo);
		checkTotalNumMin(vo);
		checkTotalNumMax(vo);
		checkInvalidNumMin(vo);
		checkInvalidNumMax(vo);
		checkPriceMin(vo);
		checkPriceMax(vo);
		checkStatus(vo);
	}
	
	private void checkVo(SearchTableReq vo) {
		
		CheckUtil.checkOther(vo);
	}
	private void checkName(SearchTableReq vo) {
	}
	private void checkTotalNumMin(SearchTableReq vo) {
		
		String totalNumMin = vo.getTotalNumMin();
		if(totalNumMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(totalNumMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(TOTAL_NUM_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(TOTAL_NUM_MIN_FIELD_NAME));
		}
	}
	private void checkTotalNumMax(SearchTableReq vo) {
		
		String totalNumMax = vo.getTotalNumMax();
		if(totalNumMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(totalNumMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(TOTAL_NUM_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(TOTAL_NUM_MAX_FIELD_NAME));
		}
	}
	private void checkInvalidNumMin(SearchTableReq vo) {
		
		String invalidNumMin = vo.getInvalidNumMin();
		if(invalidNumMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(invalidNumMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(INVALID_NUM_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(INVALID_NUM_MIN_FIELD_NAME));
		}
	}
	private void checkInvalidNumMax(SearchTableReq vo) {
		
		String invalidNumMax = vo.getInvalidNumMax();
		if(invalidNumMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(invalidNumMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(INVALID_NUM_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(INVALID_NUM_MAX_FIELD_NAME));
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
	private void checkStatus(SearchTableReq vo) {
		
		String status = vo.getStatus();
		if(status == null)
			return;
		
		try {
			
			CheckUtil.checkStringWithOptions(status, RoomStatus.getCodeStrsArray());
		}catch(StringIsNotOneOfException ex) {
			
			throw new RiCheckerException(StringIsNotOneOfException.getMsgStr(STATUS_FIELD_NAME, RoomStatus.getCodeStrsArray()));
		}
	}
}

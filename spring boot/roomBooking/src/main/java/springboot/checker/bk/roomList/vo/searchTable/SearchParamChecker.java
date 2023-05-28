package springboot.checker.bk.roomList.vo.searchTable;

import org.springframework.stereotype.Component;

import exception.check.NonIntegerNumberException;
import exception.check.NonNumberStringException;
import springboot.bean.vo.bk.roomList.searchTable.SearchParam;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.roomList.vo.searchTable.SearchParamChecker")
public class SearchParamChecker implements Checker<SearchParam> {

	public static final String TOTAL_NUM_MIN_FIELD_NAME = "總房數(最小值)";
	public static final String TOTAL_NUM_MAX_FIELD_NAME = "總房數(最大值)";
	public static final String USED_NUM_MIN_FIELD_NAME = "使用中房數(最小值)";
	public static final String USED_NUM_MAX_FIELD_NAME = "使用中房數(最大值)";
	public static final String INVALID_NUM_MIN_FIELD_NAME = "不開放房數(最小值)";
	public static final String INVALID_NUM_MAX_FIELD_NAME = "不開放房數(最大值)";
	public static final String PRICE_MIN_FIELD_NAME = "房間單價(最小值)";
	public static final String PRICE_MAX_FIELD_NAME = "房間單價(最大值)";
	
	@Override
	public void check(SearchParam vo) {
		
		checkVo(vo);
		
		checkName(vo);
		checkTotalNumMin(vo);
		checkTotalNumMax(vo);
		checkUsedNumMin(vo);
		checkUsedNumMax(vo);
		checkInvalidNumMin(vo);
		checkInvalidNumMax(vo);
		checkPriceMin(vo);
		checkPriceMax(vo);
	}
	
	private void checkVo(SearchParam vo) {
		
		CheckUtil.checkOther(vo);
	}
	private void checkName(SearchParam vo) {
	}
	private void checkTotalNumMin(SearchParam vo) {
		
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
	private void checkTotalNumMax(SearchParam vo) {
		
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
	private void checkUsedNumMin(SearchParam vo) {
		
		String usedNumMin = vo.getUsedNumMin();
		if(usedNumMin == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(usedNumMin);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(USED_NUM_MIN_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(USED_NUM_MIN_FIELD_NAME));
		}
	}
	private void checkUsedNumMax(SearchParam vo) {
		
		String usedNumMax = vo.getUsedNumMax();
		if(usedNumMax == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(usedNumMax);
		}catch(NonNumberStringException ex) {
			
			throw new RiCheckerException(NonNumberStringException.getMsgStr(USED_NUM_MAX_FIELD_NAME));
		}catch(NonIntegerNumberException ex) {
			
			throw new RiCheckerException(NonIntegerNumberException.getMsgStr(USED_NUM_MAX_FIELD_NAME));
		}
	}
	private void checkInvalidNumMin(SearchParam vo) {
		
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
	private void checkInvalidNumMax(SearchParam vo) {
		
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
	private void checkPriceMin(SearchParam vo) {
		
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
	private void checkPriceMax(SearchParam vo) {
		
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
}

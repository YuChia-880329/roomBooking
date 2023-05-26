package springboot.checker.bk.roomList.vo.ri;

import org.springframework.stereotype.Component;

import exception.check.InvalidInputException;
import exception.check.NonIntegerNumberException;
import exception.check.NonNumberStringException;
import springboot.bean.vo.bk.roomList.ri.SearchTableSearchParam;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component
public class SearchTableSearchParamChecker implements Checker<SearchTableSearchParam> {

	public static final String TOTAL_NUM_MIN_FIELD_NAME = "總房數(最小值)";
	public static final String TOTAL_NUM_MAX_FIELD_NAME = "總房數(最大值)";
	public static final String USED_NUM_MIN_FIELD_NAME = "使用中房數(最小值)";
	public static final String USED_NUM_MAX_FIELD_NAME = "使用中房數(最大值)";
	public static final String INVALID_NUM_MIN_FIELD_NAME = "不開放房數(最小值)";
	public static final String INVALID_NUM_MAX_FIELD_NAME = "不開放房數(最大值)";
	public static final String PRICE_MIN_FIELD_NAME = "房間單價(最小值)";
	public static final String PRICE_MAX_FIELD_NAME = "房間單價(最大值)";
	
	@Override
	public void check(SearchTableSearchParam vo) {
		
		checkVO(vo);
		
		checkPage(vo);
		checkName(vo);
		checkTotalNumMin(vo);
		checkTotalNumMax(vo);
		checkUsedNumMin(vo);
		checkUsedNumMax(vo);
		checkInvalidNumMin(vo);
		checkInvalidNumMax(vo);
		checkPriceMin(vo);
		checkPriceMax(vo);
		checkOrder(vo);
	}
	
	public void checkVO(SearchTableSearchParam vo) {
		
		CheckUtil.checkOther(vo);
	}
	public void checkPage(SearchTableSearchParam vo) {
		
		String page = vo.getPage();
		if(page == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(page);
		}catch(InvalidInputException ex) {
			
			vo.setPage(null);
		}
	}
	public void checkName(SearchTableSearchParam vo) {
	}
	public void checkTotalNumMin(SearchTableSearchParam vo) {
		
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
	public void checkTotalNumMax(SearchTableSearchParam vo) {
		
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
	public void checkUsedNumMin(SearchTableSearchParam vo) {
		
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
	public void checkUsedNumMax(SearchTableSearchParam vo) {
		
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
	public void checkInvalidNumMin(SearchTableSearchParam vo) {
		
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
	public void checkInvalidNumMax(SearchTableSearchParam vo) {
		
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
	public void checkPriceMin(SearchTableSearchParam vo) {
		
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
	public void checkPriceMax(SearchTableSearchParam vo) {
		
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
	public void checkOrder(SearchTableSearchParam vo) {
		
		String order = vo.getOrder();
		if(order == null)
			return;
		
		try {
			
			CheckUtil.checkStringIsIntegerNumberString(order);
		}catch(InvalidInputException ex) {
			
			vo.setOrder(null);
		}
	}
}

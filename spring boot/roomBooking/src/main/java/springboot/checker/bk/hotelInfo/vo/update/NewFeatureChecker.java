package springboot.checker.bk.hotelInfo.vo.update;

import org.springframework.stereotype.Component;

import exception.check.NullException;
import springboot.bean.vo.bk.hotelInfo.update.NewFeature;
import tmpl.checker.Checker;
import tmpl.checker.exception.RiCheckerException;
import util.CheckUtil;

@Component("bk.hotelInfo.vo.update.UpdateImageChecker")
public class NewFeatureChecker implements Checker<NewFeature> {

	@Override
	public void check(NewFeature vo) {
		
		checkVo(vo);
		
		checkId(vo);
		checkName(vo);
	}
	
	private void checkVo(NewFeature vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkId(NewFeature vo) {
	}
	private void checkName(NewFeature vo) {
		
		String name = vo.getName();
		
		try {
			
			CheckUtil.checkString(name);
		}catch(NullException ex) {
			
			throw new RiCheckerException(NullException.getMsgStr("新增特色名稱"));
		}
		
	}

}

package springboot.checker.bk.hotelInfo.vo.update;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.hotelInfo.update.NewFeature;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.hotelInfo.vo.update.NewFeatureChecker")
public class NewFeatureChecker implements Checker<NewFeature> {

	@Override
	public void check(NewFeature vo) {
		
		checkVo(vo);
		
		checkId(vo);
		checkName(vo);
		checkChecked(vo);
	}
	
	private void checkVo(NewFeature vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkId(NewFeature vo) {
	}
	private void checkName(NewFeature vo) {
	}
	private void checkChecked(NewFeature vo) {
	}
}

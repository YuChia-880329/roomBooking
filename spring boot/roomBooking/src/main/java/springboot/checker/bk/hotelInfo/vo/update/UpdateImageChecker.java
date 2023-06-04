package springboot.checker.bk.hotelInfo.vo.update;

import org.springframework.stereotype.Component;

import springboot.bean.vo.bk.hotelInfo.update.UpdateImage;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.hotelInfo.vo.update.UpdateImageChecker")
public class UpdateImageChecker implements Checker<UpdateImage> {

	@Override
	public void check(UpdateImage vo) {
		
		checkVo(vo);
		
		checkNeedUpdate(vo);
		checkImageName(vo);
		checkFile(vo);
	}
	
	private void checkVo(UpdateImage vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkNeedUpdate(UpdateImage vo) {
	}
	private void checkImageName(UpdateImage vo) {
	}
	private void checkFile(UpdateImage vo) {
	}
}

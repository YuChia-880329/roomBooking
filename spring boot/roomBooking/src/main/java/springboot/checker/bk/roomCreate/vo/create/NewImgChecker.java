package springboot.checker.bk.roomCreate.vo.create;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import springboot.bean.vo.bk.roomCreate.create.NewImg;
import tmpl.checker.Checker;
import util.CheckUtil;

@Component("bk.roomCreate.vo.create.NewImgChecker")
public class NewImgChecker implements Checker<NewImg> {

	@Override
	public void check(NewImg vo) {
		
		checkVo(vo);
		
		checkIdNumber(vo);
		checkImgName(vo);
		checkFile(vo);
	}
	
	private void checkVo(NewImg vo) {
		
		CheckUtil.checkOther(vo);
	}
	
	private void checkIdNumber(NewImg vo) {
		
		int idNumber = vo.getIdNumber();
		
		CheckUtil.checkNumberIsPositiveInteger(idNumber);
	}
	private void checkImgName(NewImg vo) {
		
		String imgName = vo.getImgName();
		
		CheckUtil.checkString(imgName);
	}
	private void checkFile(NewImg vo) {
		
		MultipartFile file = vo.getFile();
		
		CheckUtil.checkOther(file);
	}
}
